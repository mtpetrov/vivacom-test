package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private final String SHOPPING_CART_URL = "https://www.vivacom.bg/online/bg/shop/shopping-cart";

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@title = 'Продължи с пазаруването']")
    private WebElement continueShopping;
    @FindBy(xpath = "//div[@class = 'row final-price']/span[2]")
    private WebElement totalSum;
    @FindBy(xpath = "//div[2]/div[1]/form/button/em")
    private WebElement removeItem;
    @FindBy(xpath = "//button[@class ='btn btn-success js-checkout-btn disable-elm']")
    private WebElement orderButtonDisabledState;

    @FindBy(xpath = "//button[text()='Поръчай като настоящ клиент']")
    private WebElement orderAsACurrentClient;
    @FindBy(xpath = "//button[text() ='Поръчай като нов клиент']")
    private WebElement orderAsNewClient;
    @FindBy(xpath = "//a[text()=' Общи условия за мобилни услуги']")
    private WebElement termsAndConditions;
    @FindBy(xpath = "//label[@class='tac-cart-checkbox custom-checkbox']/em")
    private WebElement termsAndConditionsButton;
    @FindBy(xpath = "//button[@class='btn btn-success js-checkout-btn']")
    private WebElement orderButtonEnabledState;
    @FindBy(xpath = "//h3[text()='В момента кошницата ви е празна']")
    private WebElement emptyShoppingCartMessage1;
    @FindBy(xpath = "//p[contains (text(), 'Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете')]")
    private WebElement emptyShoppingCartMessage2;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public boolean verifyShoppingCartURL(){
        return wait.until(ExpectedConditions.urlToBe(SHOPPING_CART_URL));
    }
    public void continueShopping(){
        continueShopping.click();
    }

    public void removeItemsAbove1900(){
        String totalSumText = totalSum.getText();
        String numericPart = totalSumText.replaceAll("[^0-9]", "");
        int totalSumInt = Integer.parseInt(numericPart);
        if(totalSumInt > 1900){
            removeItem.click();
        }
    }

    public boolean verifyOrderButtonsAreDisabled(){
        try {
            wait.until(ExpectedConditions.invisibilityOf(orderButtonEnabledState));
        } catch (StaleElementReferenceException e){
            orderButtonEnabledState = driver.findElement(By.xpath("//button[@class='btn btn-success js-checkout-btn']"));
            wait.until(ExpectedConditions.invisibilityOf(orderButtonEnabledState));
        }
        return wait.until(ExpectedConditions.invisibilityOf(orderButtonEnabledState));
    }

    public boolean verifyTermsAndConditionsIsDisplayed(){
        return termsAndConditionsButton.isDisplayed();
    }
    public void acceptTermsAndConditions(){
        termsAndConditionsButton.click();
    }
    public void removeItem(){
        removeItem.click();
    }
    public boolean verifyEmptyShoppingCartMessage(){
        String emptyCartMessage1 = emptyShoppingCartMessage1.getText();
        String emptyCartMessage2 = emptyShoppingCartMessage2.getText();

        String fullEmptyMessage = emptyCartMessage1 + emptyCartMessage2;

        return fullEmptyMessage.equals("В момента кошницата ви е празна\n" +
                "Вижте актуалните ни оферти и изберете най-подходящата за вас. Ако искате да разгледате предходно добавени продукти, натиснете \"Вход\".");
    }

}

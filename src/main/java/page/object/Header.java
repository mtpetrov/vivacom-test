package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//a[@data-toggle = 'dropdown' and contains (text(),'Устройства')]")
    private WebElement ustroistva;
    @FindBy(xpath = "//div[@class = 'dropdown-link-text']/a[contains (text(),'Мобилни телефони')]")
    private WebElement mobilniTelefoni;
    @FindBy(xpath = "//a[contains(@href, '/online/bg/shop/shopping-cart')]")
    private WebElement shoppingCart;
    @FindBy(xpath = "//a[contains(@href, 'product-category-accessories')]")
    private WebElement accessories;


    public Header(WebDriver driver){
this.driver = driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void clickUstroistva(){
        ustroistva.click();
    }

    public void clickMobilniTelefoni(){
        ustroistva.click();
        wait.until(ExpectedConditions.visibilityOf(mobilniTelefoni)).click();
    }


    public void clickShoppingCart() {
        try {
            Thread.sleep(3000);
            shoppingCart.click();
        } catch (StaleElementReferenceException | InterruptedException e) {
            shoppingCart = driver.findElement(By.xpath("//a[contains(@href, '/online/bg/shop/shopping-cart')]"));
        }

    }
    public void clickAccessories(){
        ustroistva.click();
        accessories.click();
    }

}

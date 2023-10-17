package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@class = 'e-care-home-big-bill-price-digits js-related-offer-cash-price-span' and contains (text(), '1899.98')]")
    private WebElement unlimited300OneTimePaymentButton;
    @FindBy(id = "xSellBtn")
    private WebElement clientsWithoutFixedServiceButton;
    @FindBy(xpath = "//div[@class = 'button-wrapper button-wrapper-modified js-add-offer-btn-wrapper w-100']")
    private WebElement buyButton;


    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void choosePlan(){
        unlimited300OneTimePaymentButton.click();
        clientsWithoutFixedServiceButton.click();
        buyButton.click();
    }
    public void buy(){
        buyButton.click();
    }
}

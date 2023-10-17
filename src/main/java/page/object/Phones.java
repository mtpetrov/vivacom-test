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

public class Phones {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//input[@val = 'APPLE']/following::em[1]")
    private WebElement appleCheckbox;
    @FindBy(xpath = "//span[@class = 'analytics-skip' and contains (text(), 'BLUE')]")
    private WebElement blueCheckbox;
    @FindBy(xpath = "//h3[text() ='APPLE IPHONE 15 PLUS 128GB']")
    private WebElement iPhone15Plus128GB;
    @FindBy(xpath = "//div[@id ='c-right']/a[1]")
    private WebElement acceptCookies;



    public Phones (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectBlueIphone15Plus128GB(){
        appleCheckbox.click();
        blueCheckbox.click();

        try {
            iPhone15Plus128GB.click();
        } catch (StaleElementReferenceException e) {
            iPhone15Plus128GB = driver.findElement(By.xpath("//div[@class = 'e-shop-devices-product-details-phone-grid-box']/ancestor::a[contains(@href,'apple-iphone-15-plus-128gb')]"));
            iPhone15Plus128GB.click();
        }
    }
}

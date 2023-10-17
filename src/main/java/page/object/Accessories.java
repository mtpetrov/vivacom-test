package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Accessories {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//span[text() ='над 40 лв.']")
    private WebElement above40lv;
    @FindBy(xpath = "//input[@val = 'APPLE']/following::em[1]")
    private WebElement appleCheckbox;
    @FindBy(xpath = "//h3[text() ='APPLE iPhone 15 Plus FineWoven Taupe']")
    private WebElement iPhone15PlusFineWovenTaupeCase;
    public Accessories(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectIphone15PlusFineWovenTaupeCase(){
        appleCheckbox.click();
        above40lv.click();
        try {
            iPhone15PlusFineWovenTaupeCase.click();
        } catch (StaleElementReferenceException e){
            iPhone15PlusFineWovenTaupeCase = driver.findElement(By.xpath("//h3[text() ='APPLE iPhone 15 Plus FineWoven Taupe']"));
            iPhone15PlusFineWovenTaupeCase.click();
        }

    }
}

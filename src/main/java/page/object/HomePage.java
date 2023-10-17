package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final String BASE_URL = "https://www.vivacom.bg/bg/";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='c-right']/a[1]")
    private WebElement acceptCookies;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }
    public void navigateTo(){
        driver.navigate().to(BASE_URL);
    }

    public void acceptCookies(){
        acceptCookies.click();
    }
}

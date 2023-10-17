import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import page.object.*;

public class Test extends TestSetupObject{
    @org.testng.annotations.Test(invocationCount = 10)
    public void test(){
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        homePage.acceptCookies();

        Header header = new Header(getDriver());
        header.clickMobilniTelefoni();

        Phones phones = new Phones(getDriver());
        phones.selectBlueIphone15Plus128GB();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.choosePlan();
        header.clickShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

        Assert.assertTrue(shoppingCartPage.verifyShoppingCartURL(), "User was not redirected to the shopping cart");
        shoppingCartPage.continueShopping();

        header.clickAccessories();

        Accessories accessories = new Accessories(getDriver());
        accessories.selectIphone15PlusFineWovenTaupeCase();

        productPage.buy();
        Assert.assertTrue(shoppingCartPage.verifyShoppingCartURL(), "User was not redirected to the shopping cart");
        shoppingCartPage.removeItemsAbove1900();

        Assert.assertTrue(shoppingCartPage.verifyOrderButtonsAreDisabled());
        Assert.assertTrue(shoppingCartPage.verifyTermsAndConditionsIsDisplayed(), "The terms and conditions button is not displayed");

        shoppingCartPage.acceptTermsAndConditions();
        shoppingCartPage.removeItem();

    }
}

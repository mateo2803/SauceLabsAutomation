import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utilities.DriverManager;

public class CheckoutTests extends BaseTest {
    @Test()
    public void verificarCarritoPasaSinItems() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();
        Thread.sleep(2000);
        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnCheckOutButton();
        Thread.sleep(2000);
        InformationPage informationPage = new InformationPage(DriverManager.getDriver().driver);
        Assert.assertTrue(informationPage.verifyContinueButton());
    }

    @Test()
    public void verificarContinueShopping() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnAddBackPack();
        Thread.sleep(2000);

        homePage.clickOnCartButton();
        Thread.sleep(5000);

        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnContinueShoppingButton();


        Assert.assertTrue(homePage.verifyAppLogo());
    }

//    @Test
//    public void verificarCheckoutButton() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
//        loginPage.setUsernameTextBox("standard_user");
//        loginPage.setPasswordTextBox("secret_sauce");
//        loginPage.clickLoginButton();
//
//        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
//        homePage.clickOnAddBackPack();
//        Thread.sleep(2000);
//
//        homePage.clickOnCartButton();
//        Thread.sleep(3000);
//
//        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
//        checkoutPage.clickOnCheckOutButton();
//        Thread.sleep(3000);
//
//        Assert.assertFalse(checkoutPage.verifyCheckOutButton());
//    }

}

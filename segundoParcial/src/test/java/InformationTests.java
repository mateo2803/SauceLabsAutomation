import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utilities.DriverManager;

public class InformationTests extends BaseTest{

    @Test
    public void informationSuccessTest() throws InterruptedException {
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
        informationPage.setFirstNameTextBox("Luis");
        informationPage.setLastnameTextBox("Tejerina");
        informationPage.setPostalCodeTextBox("0000");
        Thread.sleep(2000);
        informationPage.clickContinueButton();

        OverviewPage overviewPage = new OverviewPage(DriverManager.getDriver().driver);
        Assert.assertTrue(overviewPage.verifyFinishButton());
    }

    //Mensajes de error Checkot Information

    @Test
    public void informationNoFirstNameTest() throws InterruptedException {
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
        informationPage.setFirstNameTextBox("");
        informationPage.setLastnameTextBox("Clarks");
        informationPage.setPostalCodeTextBox("9090");
        Thread.sleep(2000);
        informationPage.clickContinueButton();

        Assert.assertTrue(informationPage.verifyErrorMessage());
    }
}

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginTests extends BaseTest{

    @Test
    public void loginSuccessTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        Assert.assertTrue(homePage.verifyAppLogo());
        Thread.sleep(5000);
    }

    @Test
    public void loginFailedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sa");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        Assert.assertTrue(homePage.verifyErrorMessage());
        Thread.sleep(5000);
    }
}

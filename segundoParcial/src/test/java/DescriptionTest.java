import org.junit.Assert;
import org.junit.Test;
import pages.DescriptionPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class DescriptionTest extends BaseTest{

    @Test()
    public void verificarNumeroCarritoSube(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        DescriptionPage descriptionPage = new DescriptionPage(DriverManager.getDriver().driver);
        descriptionPage.clickOnAddBackPack();
        System.out.println(descriptionPage.getTextItemCarrito());
        Assert.assertEquals(descriptionPage.getTextItemCarrito(),"1");
    }

    @Test
    public void verificarNumeroCarritoBaja() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnAddBackPack();
        homePage.clickOnRemoveBackPack();
        System.out.println(homePage.getTextItemCarrito());
        Assert.assertNotEquals(homePage.getTextItemCarrito(),"1");
        Thread.sleep(5000);
    }
}

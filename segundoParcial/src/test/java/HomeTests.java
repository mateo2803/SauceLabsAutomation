import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

import java.time.Duration;
import java.util.List;

public class HomeTests extends BaseTest {

    @Test
    public void verificarCartNumberPlus() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnAddBackPack();
        System.out.println(homePage.getTextItemCarrito());
        Assert.assertEquals(homePage.getTextItemCarrito(),"1");
        Thread.sleep(5000);
    }
    @Test
    public void verificarCartNumberLess() throws InterruptedException {
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

    @Test
    public void verificarClickOnCarritoCheckOut() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();

        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        Assert.assertTrue(checkoutPage.verifyCheckOutButton());
        Thread.sleep(5000);
    }

    @Test
    public void verificarFuncionAbout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnMenu();
        homePage.clickOnAbout();
        Assert.assertTrue(homePage.verifyElementAboutPage());
        Thread.sleep(5000);
        //Assert.assertTrue(homePage.verifyElementAboutPage());
    }

    @Test
    public void verificarAlDarClickEnNombre() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnNombreItem();
        Assert.assertTrue(homePage.verifyElementBotonBack());
        Thread.sleep(5000);
        //Assert.assertTrue(homePage.verifyElementAboutPage());
    }

    @Test
    public void verifyHighToLowPriceItemFilterTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();
        //Filtrando
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectProductFilter("Price (low to high)");

        Thread.sleep(5000);
        List<Double> prices = homePage.getAllItemPrices();

        for (Double price:prices){
            System.out.println(price);
        }
        //boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);

    }

    @Test
    public void verifyLowToHighPriceItemFilterTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();
        //Filtrando
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectProductFilter("Price (high to low)");

        Thread.sleep(5000);
        List<Double> prices = homePage.getAllItemPrices();

        for (Double price:prices){
            System.out.println(price);
        }
        boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

    @Test
    public void verifyTwitterLink() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnTwitterButton();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://twitter.com/saucelabs"));

        String currentURL = DriverManager.getDriver().driver.getCurrentUrl();
        Assert.assertTrue(homePage.verifyTwitterLink(currentURL));

    }

}

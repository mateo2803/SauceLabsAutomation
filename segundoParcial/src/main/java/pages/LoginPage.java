package pages;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    //Page object vas a tener un objeto por cada pagina en esta es todo del Login
    @FindBy(id="user-name")
    WebElement usernameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(id="login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsernameTextBox(String username){
        usernameTextBox.sendKeys(username);
    }

    public void setPasswordTextBox(String password){
        passwordTextBox.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {

    WebDriver driver;
    public InformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "continue")
    WebElement botonContinue;

    public boolean verifyContinueButton() {
        boolean verifyContinueButton = botonContinue.isDisplayed();
        return verifyContinueButton;
    }

    @FindBy(id="first-name")
    WebElement firstnameTextBox;

    @FindBy(id="last-name")
    WebElement lastnameTextBox;

    @FindBy(id="postal-code")
    WebElement postalCodeTextBox;

    @FindBy(id="continue")
    WebElement continueButton;

    @FindBy(className = "error-button")
    WebElement errorMessage;

    public void setFirstNameTextBox(String firstname){
        firstnameTextBox.sendKeys(firstname);
    }
    public void setLastnameTextBox(String lastname){
        lastnameTextBox.sendKeys(lastname);
    }
    public void setPostalCodeTextBox(String postalcode){ postalCodeTextBox.sendKeys(postalcode); }
    public void clickContinueButton(){
        continueButton.click();
    }
    public boolean verifyErrorMessage() {
        boolean verifyErrorMessage = errorMessage.isDisplayed();
        return verifyErrorMessage;
    }
}

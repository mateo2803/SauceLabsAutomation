package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    WebDriver driver;
    public OverviewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "finish")
    WebElement finishButton;

    public boolean verifyFinishButton() {
        boolean verifyFinishButton = finishButton.isDisplayed();
        return verifyFinishButton;
    }
}

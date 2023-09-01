package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage {
    //Sauce Labs Backpack
    WebDriver driver;

    public DescriptionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButtonBackPack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartButtonBikeLight;

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;


    public void clickOnAddToCart(){
        addToCartButtonBackPack.click();
    }

    public String getTextItemCarrito(){
        String textoCarrito = iconoCarrito.getText();
        return textoCarrito;
    }
    public void clickOnAddBackPack(){
        addToCartButtonBackPack.click();
    }

    public void clickOnAddBikeLight(){
        addToCartButtonBikeLight.click();
    }
}

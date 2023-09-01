package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.FilteredRowSet;
import java.util.ArrayList;
import java.util.List;


public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveButton;

    @FindBy(className = "error-button")
    WebElement errorMessage;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyAppLogo() {
        boolean verifyAppLogo = appLogo.isDisplayed();
        return verifyAppLogo;
    }

    public boolean verifyErrorMessage() {
        boolean verifyErrorMessage = errorMessage.isDisplayed();
        return verifyErrorMessage;
    }

    public String getTextItemCarrito(){
        String textoCarrito = iconoCarrito.getText();
        return textoCarrito;
    }

    public void clickOnAddBackPack(){
        sauceLabsBackAddToCartButton.click();
    }
    public void clickOnRemoveBackPack(){
        sauceLabsBackPackRemoveButton.click();
    }


    // MENU -----------------------------------------

    @FindBy(id = "react-burger-menu-btn")
    WebElement botonMenu;

    @FindBy(id = "about_sidebar_link")
    WebElement sliderMenu;

    @FindBy(className = "nav-image-link")
    WebElement elementoPaginaAbout;
    public void clickOnMenu(){
        botonMenu.click();
    }

    public void clickOnAbout(){
        sliderMenu.click();
    }

    public boolean verifyElementAboutPage() {
        boolean verifyElementAboutPage = elementoPaginaAbout.isDisplayed();
        return verifyElementAboutPage;
    }
    //----------Descripcion

    @FindBy(className = "inventory_item_name")
    WebElement nombreItem;

    public void clickOnNombreItem(){
        nombreItem.click();
    }

    @FindBy(id = "back-to-products")
    WebElement botonBackToProducts;
    public boolean verifyElementBotonBack() {
        boolean verifyElementBotonBack = botonBackToProducts.isDisplayed();
        return verifyElementBotonBack;
    }

    //----------------------------------FILTROS------------------------

    // FILTROS -----------------------------------------

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    public void selectProductFilter(String element){
        Select selectObject = new Select(productFilterDropDown);
        selectObject.selectByVisibleText(element);
    }

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;

    public List<Double> getAllItemPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel){
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }

    //------------------------------------------

    @FindBy(className = "shopping_cart_link")
    WebElement botonCarrito;

    public void clickOnCartButton(){
        botonCarrito.click();
    }

    @FindBy(className = "social_twitter")
    WebElement botonTwitter;
    public void clickOnTwitterButton(){
        botonTwitter.click();
    }
    public boolean verifyTwitterLink(String currentURL) {
        String expectedURL = "https://twitter.com/saucelabs";
        return currentURL.equals(expectedURL);
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement botonCarrito;

    public void clickOnCartButton(){
        botonCarrito.click();
    }

    @FindBy(id = "checkout")
    WebElement botonCheckout;

    public void clickOnCheckOutButton(){
        botonCheckout.click();
    }

    public boolean verifyCheckOutButton() {
        boolean verifyNoItems = botonCheckout.isDisplayed();
        return verifyNoItems;
    }

    @FindBy(id = "continue-shopping")
    WebElement botonCContinueShopping;

    public void clickOnContinueShoppingButton(){
        botonCContinueShopping.click();
    }

//    public void clickOnCheck


    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;

    public List<String> getAllItemPrices(){
        List<String> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel){
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            //sb.deleteCharAt(0);
            prices.add(sb.toString());
        }
        return prices;
    }

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeButton1;

    public void clickOnRemoveBackPack(){
        removeButton1.click();
    }

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeButton2;

    public void clickOnRemoveBike(){
        removeButton2.click();
    }

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;
    public String getTextItemCarrito(){
        String textoCarrito = iconoCarrito.getText();
        return textoCarrito;
    }


    public boolean verifyNoItems() {
        boolean verifyNoItems = iconoCarrito.isDisplayed();
        return verifyNoItems;
    }

    @FindBy(className = "cart_item")
    List<WebElement> listaCarrito;

    public boolean listaVaciaItem(){
        boolean a = listaCarrito.isEmpty();
        return a;
    }

    @FindBy(className = "inventory_item_name")
    WebElement nombreitemBP;

    @FindBy(className = "inventory_item_name")
    WebElement nombreitemBike;

    public boolean verifyNoItemsByNameBackPack() {
        boolean verifyNoItems = nombreitemBP.isDisplayed();
        return verifyNoItems;
    }

    public boolean verifyNoItemsByNameBike() {
        boolean verifyNoItems = nombreitemBike.isDisplayed();
        return verifyNoItems;
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;

    // Butonul cosului
    private By cartButton = By.id("shopping_cart_container");

    // Buton remove pentru Bolt T-Shirt
    private By removeBoltTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");

    // Buton Checkout
    private By checkoutButton = By.id("checkout");

    // Buton Continue Shopping
    private By continueShoppingButton = By.id("continue-shopping");

    // Produse în cos (XPath robust cu contains)
    private By backpackItem = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Backpack')]");
    private By bikeLightItem = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bike Light')]");
    private By boltTShirtItem = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bolt T-Shirt')]");
    private By fleeceJacketItem = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Fleece Jacket')]");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Deschide cosul
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    // Șterge Bolt T-Shirt din cos
    public void removeBoltTShirt() {
        driver.findElement(removeBoltTShirtButton).click();
    }

    // Checkout
    public void checkout() {
        driver.findElement(checkoutButton).click();
    }

    // Revine la pagina produselor
    public void continueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    // Verificare dacă un produs este în cos
    public boolean isProductInCart(String productName) {
        switch (productName) {
            case "Backpack": return driver.findElements(backpackItem).size() > 0;
            case "Bike Light": return driver.findElements(bikeLightItem).size() > 0;
            case "Bolt T-Shirt": return driver.findElements(boltTShirtItem).size() > 0;
            case "Fleece Jacket": return driver.findElements(fleeceJacketItem).size() > 0;
            default: return false;
        }
    }
}

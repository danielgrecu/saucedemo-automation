package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;

    // Butonul de cos
    private By cartButton = By.className("shopping_cart_link");

    // Buton remove Bolt T-Shirt
    private By removeBoltTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");

    // Buton Checkout
    private By checkoutButton = By.id("checkout");

    // Buton Continue Shopping
    private By continueShoppingButton = By.id("continue-shopping");

    // Produse in cos
    private By backpackItem = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");
    private By bikeLightItem = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']");
    private By boltTShirtItem = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']");
    private By fleeceJacketItem = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Fleece Jacket']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Deschide cosul
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    // Sterge Bolt T-Shirt din cos
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

    // Verificare daca un produs este in cos
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

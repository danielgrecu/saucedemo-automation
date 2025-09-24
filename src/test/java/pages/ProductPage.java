package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    // Butoane Add to cart
    private By backpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By boltTShirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By fleeceJacketButton = By.id("add-to-cart-sauce-labs-fleece-jacket");

    // Filtru
    private By filterDropdown = By.cssSelector(".product_sort_container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Aplicare filtru dupa pret
    public void applyFilter(String filterOption) {
        driver.findElement(filterDropdown).click();
        driver.findElement(By.xpath("//option[text()='" + filterOption + "']")).click();
    }

    // Adaugare produse
    public void addBackpack() {
        driver.findElement(backpackButton).click();
    }

    public void addBikeLight() {
        driver.findElement(bikeLightButton).click();
    }

    public void addBoltTShirt() {
        driver.findElement(boltTShirtButton).click();
    }

    public void addFleeceJacket() {
        driver.findElement(fleeceJacketButton).click();
    }
}

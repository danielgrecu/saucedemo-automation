package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Exemplu de metode pentru produse individuale
    public void addBackpack() {
        String xpath = "//div[@class='inventory_item']//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void addBikeLight() {
        String xpath = "//div[@class='inventory_item']//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void applyFilter(String filterOption) {
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.xpath("//option[text()='" + filterOption + "']")).click();
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}

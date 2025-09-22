package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpack() {
        driver.findElement(By.xpath("//div[@class='inventory_item']//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
    }

    public void addBikeLight() {
        driver.findElement(By.xpath("//div[@class='inventory_item']//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//button")).click();
    }

    public void applyFilter(String filterOption) {
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.xpath("//option[text()='" + filterOption + "']")).click();
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}

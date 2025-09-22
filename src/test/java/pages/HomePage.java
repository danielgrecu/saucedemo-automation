package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By productLink = By.cssSelector(".inventory_item_name");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openFirstProduct() {
        driver.findElement(productLink).click();
    }
}

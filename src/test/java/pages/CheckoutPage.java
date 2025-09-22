package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Campuri de completat pentru procesarea comenzii
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");

    // Buton Continue in checkout
    private By continueButton = By.id("continue");

    // Buton Finish pentru finalizarea comenzii
    private By finishButton = By.id("finish");

    // Mesaj de confirmare comanda
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Introduce datele necesare pentru checkout si apasa Continue
    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    // Finalizeaza comanda
    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

    // Returneaza mesajul de confirmare a comenzii
    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}

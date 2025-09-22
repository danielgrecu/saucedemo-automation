package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    /*
     * Scenariu 1:
     * 1. Logare cu date valide
     * 2. Aplicare filtru produse "Name (A to Z)"
     * 3. Adaugare 2 produse in cos: "Backpack" si "Bike Light"
     * 4. Accesare cos de cumparaturi
     * 5. Finalizare comanda (checkout)
     * 6. Verificare mesaj final "THANK YOU FOR YOUR ORDER"
     */

    @Test
    public void completePurchaseScenario() {
        WebDriver driver = DriverFactory.getDriver();
        try {
            // Acceseaza site-ul SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Logare cu username si password
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            // Pagina de produse
            ProductPage productPage = new ProductPage(driver);

            // Aplicare filtru produse
            productPage.applyFilter("Name (A to Z)");

            // Adaugare produse in cos
            productPage.addBackpack();
            productPage.addBikeLight();

            // Mergi la cosul de cumparaturi
            ShoppingCartPage cartPage = new ShoppingCartPage(driver);
            cartPage.openCart();

            // Incepere checkout
            cartPage.checkout();

            // Pagina checkout
            CheckoutPage checkoutPage = new CheckoutPage(driver);

            // Introducere date pentru finalizare comanda
            checkoutPage.enterCheckoutInfo("Daniel", "Grecu", "240150");

            // Finalizare comanda
            checkoutPage.finishCheckout();

            // Verificare mesaj final
            String confirmation = checkoutPage.getConfirmationMessage();
            assertEquals("THANK YOU FOR YOUR ORDER", confirmation);

        } finally {
            // Inchide browserul intotdeauna
            DriverFactory.quitDriver();
        }
    }
}

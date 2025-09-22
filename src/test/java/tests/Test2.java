package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

    /*
     * Scenariu 2:
     * 1. Autentificare cu date valide
     * 2. Aplicare filtru pret "Low to High"
     * 3. Adaugare primele 3 produse in cos (din pagina produsului)
     * 4. Accesare cos de cumparaturi si scoatere al 3-lea produs (Bolt T-Shirt)
     * 5. Aplicare filtru pret "Low to High" si adaugarea celui de-al 4-lea produs
     * 6. Finalizare comanda (Checkout)
     */

    @Test
    public void purchaseScenarioWithRemoval() {
        WebDriver driver = DriverFactory.getDriver();
        try {
            // Acceseaza site-ul SauceDemo
            driver.get("https://www.saucedemo.com/");

            // Logare
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            // Pagina de produse
            ProductPage productPage = new ProductPage(driver);

            // Aplicare filtru pret "Low to High"
            productPage.applyFilter("Price (low to high)");

            // Adaugare primele 3 produse in cos
            productPage.addBackpack();
            productPage.addBikeLight();
            productPage.addBoltTShirt();

            // Pauza scurta
            Thread.sleep(500);

            // Mergi la cosul de cumparaturi
            ShoppingCartPage cartPage = new ShoppingCartPage(driver);
            cartPage.openCart();
            Thread.sleep(500);

            // Scoate Bolt T-Shirt
            cartPage.removeBoltTShirt();
            Thread.sleep(500);

            // Revenire la pagina produselor
            cartPage.continueShopping();

            // Aplicare filtru si adaugare Fleece Jacket
            productPage.applyFilter("Price (low to high)");
            productPage.addFleeceJacket();

            // Checkout
            cartPage.checkout();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.enterCheckoutInfo("Daniel", "Grecu", "240150");
            checkoutPage.finishCheckout();

            // Verificare mesaj final
            String confirmation = checkoutPage.getConfirmationMessage();
            assertEquals("THANK YOU FOR YOUR ORDER", confirmation);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Inchide browserul intotdeauna
            DriverFactory.quitDriver();
        }
    }
}

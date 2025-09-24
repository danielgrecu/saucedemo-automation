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
        WebDriver drv=DriverFactory.getDriver();
        try{


// Acceseaza site-ul SauceDemo

            drv.get("https://www.saucedemo.com/");

// Logare
            LoginPage login = new LoginPage(drv);
            login.login("standard_user","secret_sauce");

// Pagina de produse

            ProductPage prod = new ProductPage(drv);

// Aplicare filtru pret "Low to High"

            prod.applyFilter("Price (low to high)");

// Adaugare primele 3 produse in cos

            prod.addBackpack();
            prod.addBikeLight();
            prod.addBoltTShirt();

// Pauza scurta pentru sincronizare Selenium-Browser

            Thread.sleep(500);

// Mergi la cosul de cumparaturi

            ShoppingCartPage cart = new ShoppingCartPage(drv);
            cart.openCart();
            Thread.sleep(500);

// Scoate Bolt T-Shirt

            cart.removeBoltTShirt();
            Thread.sleep(500);

// Revenire la pagina produselor

            cart.continueShopping();

// Aplicare filtru si adaugare Fleece Jacket

            prod.applyFilter("Price (low to high)");
            prod.addFleeceJacket();

// Checkout

            cart.checkout();
            CheckoutPage co = new CheckoutPage(drv);
            co.enterCheckoutInfo("Daniel","Grecu","240150");
            co.finishCheckout();

// Verificare mesaj final

            String msg = co.getConfirmationMessage();
            assertEquals("Thank you for your order!", msg);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

// Inchide browserul intotdeauna

            DriverFactory.quitDriver();

 }}
}

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
        WebDriver drv=DriverFactory.getDriver();
        try{

// Acceseaza site-ul SauceDemo

            drv.get("https://www.saucedemo.com/");

// Logare cu username si password

            LoginPage login = new LoginPage(drv);
            login.login("standard_user","secret_sauce");

// Pagina de produse

            ProductPage prod = new ProductPage(drv);
            prod.applyFilter("Name (A to Z)");

// Adaugare produse in cos

            prod.addBackpack();
            prod.addBikeLight();

// Mergi la cosul de cumparaturi

            ShoppingCartPage cart = new ShoppingCartPage(drv);
            cart.openCart();
            cart.checkout();

// Pagina checkout

            CheckoutPage co = new CheckoutPage(drv);
            co.enterCheckoutInfo("Daniel","Grecu","240150");
            co.finishCheckout();

// Verificare mesaj final

            String msg=co.getConfirmationMessage();
            assertEquals("THANK YOU FOR YOUR ORDER", msg);

        } finally {
            DriverFactory.quitDriver();
        }
    }
}

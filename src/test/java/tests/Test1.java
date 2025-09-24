package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    /*
     * Scenariu 1 – Achizitie completa cu 2 produse
     *
     * Pasi automatizati:
     * 1. Acceseaza site-ul SauceDemo
     * 2. Logare cu date valide (username: standard_user, parola: secret_sauce)
     * 3. Aplica filtrul produse "Name (A to Z)"
     * 4. Adauga 2 produse in cos: Backpack si Bike Light
     * 5. Acceseaza cosul de cumparaturi
     * 6. Finalizeaza comanda (Checkout) completand informatiile: Daniel Grecu, cod postal 240150
     * 7. Verifica mesajul final de confirmare: "Thank you for your order!"
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
            assertEquals("Thank you for your order!", msg);

        } finally {
            DriverFactory.quitDriver();
        }
    }
}

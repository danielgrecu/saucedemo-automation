package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaucedemoTest {

    @Test
    public void completePurchaseScenario() {
        // Deschide browserul
        WebDriver driver = DriverFactory.getDriver();

        // Se acceseaza site-ul SauceDemo
        driver.get(ConfigReader.get("url"));

        // Logare cu username si password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        // Pagina de home
        HomePage homePage = new HomePage(driver);

        // Aplicare filtru produse
        homePage.applyFilter("Name (A to Z)");

        // Adaugare produs Backpack in cos
        homePage.addBackpack();

        // Adaugare produs Bike Light in cos
        homePage.addBikeLight();

        // Mergi la cosul de cumparaturi
        homePage.goToCart();

        // Pagina cos de cumparaturi
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Incepere checkout
        cartPage.checkout();

        // Pagina checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Introducere date pentru finalizare comanda
        checkoutPage.enterCheckoutInfo("Daniel", "Grecu", "240150");

        // Finalizare comanda
        checkoutPage.finishCheckout();

        // Verificare mesaj final "THANK YOU FOR YOUR ORDER"
        String confirmation = checkoutPage.getConfirmationMessage();
        assertEquals("THANK YOU FOR YOUR ORDER", confirmation);

        // Pauza 7 secunde pentru a vedea mesajul final
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Inchide browserul
        DriverFactory.quitDriver();
    }
}

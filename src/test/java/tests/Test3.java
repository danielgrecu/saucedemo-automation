package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test3 {

    /*
     * Scenariu 3:
     * 1. Logare cu date incorecte (parola cu ultima literă dublată)
     * 2. Verificare mesaj de eroare
     * Browserul ramane deschis pentru inspectie
     */

    @Test
    public void loginWithWrongPassword() {
        WebDriver driver = DriverFactory.getDriver();

        // Acceseaza site-ul SauceDemo
        driver.get("https://www.saucedemo.com/");

        // Logare cu username corect si parola cu ultima litera dublata
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_saucee");

        // Verificare ca mesajul de eroare este afisat
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Epic sadface"), "Eroarea de logare nu este afisata!");

        // Browserul ramane deschis
    }
}

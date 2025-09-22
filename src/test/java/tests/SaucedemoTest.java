package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaucedemoTest {

    WebDriver driver;

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

      //logare in saucedemo cu user: standard_user si parola: secret_sauce

        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        Thread.sleep(2000);


//sortarea produselor low to high:

        WebElement selectElem =  driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
        Select select = new Select(selectElem);
        select.selectByValue("lohi");

// click pe produsul Sauce Labs Onesie,  adaugarea in cos si revenirea la pagina

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("back-to-products")).click();

//sortarea produselor high to low:


        WebElement selectElem2 = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
        Select select2 = new Select(selectElem2);
        select2.selectByValue("hilo");



// click pe produsul Sauce Labs Fleece Jacket,  adaugarea in cos si revenirea la pagina

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("back-to-products")).click();

// click pe cosul de cumparaturi

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();

// eliminarea produsului Sauce Labs Fleece Jacket din cosul de cumparaturi

        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();

// apasarea butonului checkout, completarea campurilor, apasarea butonului de continuare si de finalizare a comenzii

        driver.findElement(By.id("checkout")).click();


        driver.findElement(By.id("first-name")).sendKeys("Ion");
        driver.findElement(By.id("last-name")).sendKeys("Popescu");
        driver.findElement(By.id("postal-code")).sendKeys("123456");

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

// Verificarea mesajului de finalizare a comenzii

        WebElement finalMessage = driver.findElement(By.className("complete-header"));
        String messageText = finalMessage.getText();
        assertEquals("Thank you for your order!", messageText);


        Thread.sleep(5000);

        System.out.println("Testul s-a terminat cu succes!");


    }

    @AfterEach
    public void closeBrowser(){

        driver.quit();
    }


}

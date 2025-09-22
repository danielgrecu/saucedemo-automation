package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

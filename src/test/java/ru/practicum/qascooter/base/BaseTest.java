package ru.practicum.qascooter.base;

import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.practicum.qascooter.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public static void setUp() {
        System.out.println("setUp() вызван");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.open();
        homePage.scrollDownEnd();
        homePage.clickCookieButton();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
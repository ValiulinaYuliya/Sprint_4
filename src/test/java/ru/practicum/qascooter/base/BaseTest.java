package ru.practicum.qascooter.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.practicum.qascooter.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    private final String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Запуск в браузере: {0}")
    public static Collection<String> browsers() {
        return Arrays.asList("chrome", "firefox");
    }

    @Before
    public void setUp() {
        System.out.println("setUp() вызван для браузера " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.open();
        homePage.scrollDownEnd();
        homePage.clickCookieButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
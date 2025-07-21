import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderPageTest {
    protected WebDriver driver;

    // Параметр для выбора браузера
    private final String browser;

    // Конструктор принимает параметр — имя браузера
    public OrderPageTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Браузер: {0}")
    public static Collection<String> browsers() {
        return Arrays.asList("chrome", "firefox");
    }

    @Before
    public void setUp() {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Замените на путь к драйверу
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Замените на путь к драйверу
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize(); // Опционально: развернуть окно браузера
    }


}



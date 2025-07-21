import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.practicum.qascooter.HomePage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class FaqPageAnswersTest {

        private static WebDriver driver;
        private static HomePage homePage;
        private final int questionNumber;
        private final String expectedAnswer;

        public FaqPageAnswersTest(int questionNumber, String expectedAnswer) {
            this.questionNumber = questionNumber;
            this.expectedAnswer = expectedAnswer;
        }
        @Parameterized.Parameters
        public static Object[][] getAnswer() {
            return new Object[][] {
                    {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
            };
        }


    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.open();
        homePage.scrollDownEnd();
        homePage.clickCookieButton();
    }

    @Test
    public void testFaqAnswerText() {
            homePage.clickQuestionButton(questionNumber);
            String actualAnswer = homePage.getAnswerText(questionNumber);

            org.junit.Assert.assertEquals(
                    "Текст ответа не совпадает для вопроса #" + questionNumber,
                    expectedAnswer,
                    actualAnswer
            );
    }

    @AfterClass
    public static void tearDown() {
            if (driver != null) {
                driver.quit();
            }
    }
  
}
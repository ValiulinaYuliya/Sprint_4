import ru.practicum.qascooter.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static org.junit.Assert.*;

public class TextHomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    public TextHomePageTest() {
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        HomePage homePage = new HomePage(this.driver);
        homePage.open();
        homePage.scrollDownEnd();
        homePage.clickCookieButton();
    }

    @Test
    public void testText1() {
        String answer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions1();
        String actualText1 = homePage.getTextAnswer1();
        System.out.println("Фактически текст: " + actualText1);
        Assert.assertEquals("Cтроки отличаются", answer1, actualText1);
    }

    @Test
    public void testText2() {
        String answer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions2();
        String actualText2 = homePage.getTextAnswer2();
        System.out.println("Фактически текст: " + actualText2);
        Assert.assertEquals("Cтроки отличаются", answer2, actualText2);
    }

    @Test
    public void testText3() {
        String answer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions3();
        String actualText3 = homePage.getTextAnswer3();
        System.out.println("Фактически текст: " + actualText3);
        Assert.assertEquals("Cтроки отличаются", answer3, actualText3);
    }

    @Test
    public void testText4() {
        String answer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions4();
        String actualText4 = homePage.getTextAnswer4();
        System.out.println("Фактически текст: " + actualText4);
        Assert.assertEquals("Cтроки отличаются", answer4, actualText4);
    }

    @Test
    public void testText5() {
        String answer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions5();
        String actualText5 = homePage.getTextAnswer5();
        System.out.println("Фактически текст: " + actualText5);
        Assert.assertEquals("Cтроки отличаются", answer5, actualText5);
    }

    @Test
    public void testText6() {
        String answer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions6();
        String actualText6 = homePage.getTextAnswer6();
        System.out.println("Фактически текст: " + actualText6);
        Assert.assertEquals("Cтроки отличаются", answer6, actualText6);
    }

    @Test
    public void testText7() {
        String answer7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions7();
        String actualText7 = homePage.getTextAnswer7();
        System.out.println("Фактически текст: " + actualText7);
        Assert.assertEquals("Cтроки отличаются", answer7, actualText7);
    }

    @Test
    public void testText8() {
        String answer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        HomePage homePage = new HomePage(this.driver);
        homePage.clickQuestions8();
        String actualText8 = homePage.getTextAnswer8();
        System.out.println("Фактически текст: " + actualText8);
        Assert.assertEquals("Cтроки отличаются", answer8, actualText8);
    }

    @After
    public void theEnd() {
        this.driver.quit();
    }
}


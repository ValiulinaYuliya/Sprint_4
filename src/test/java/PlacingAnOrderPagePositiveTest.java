import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.practicum.qascooter.base.BaseTest;

import java.time.LocalDate;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class PlacingAnOrderPagePositiveTest extends BaseTest {
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String comment;
    private LocalDate date;
    private String rentalTime;
    private String scooterColor;

    public PlacingAnOrderPagePositiveTest(String name, String lastName, String address, String phone, LocalDate date, String rentalTime, String scooterColor, String comment, String browser) {
        super(browser);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.date = date;
        this.rentalTime = rentalTime;
        this.scooterColor = scooterColor;
    }

    @Before
    public void setUp() {
        super.setUp();
    }

    //проверка заполнения полей ввода в форме заказа
    @Parameterized.Parameters(name = "Позитивный тест: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] checkInputFieldPositive() {
        return new Object[][]{
                {"Иван", "Иванов", "г. Москва, ул. Ленина, д. 1", "89999999999", LocalDate.now().plusDays(1), "сутки", "black", "Комментарий", "firefox"},
                {"Петр", "Петров", "Адресный адрес 1", "89419856578", LocalDate.now().plusDays(2), "двое суток", "grey", "трулала трулаленд", "firefox"},
                {"Александр", "Александров", "Адресный адрес 2", "89419856578", LocalDate.now().plusDays(3), "трое суток", "black", "трулала трулаленд", "chrome"},
                {"Алексей", "Алексеев", "Адресный адрес 3", "89419856578", LocalDate.now().plusDays(4), "четверо суток", "grey", "трулала трулаленд", "chrome"},
        };
    }

//тестирование создание заказа через кнопку "Заказать" в шапке сайта (позитивный)
    @Test
    public void orderButtonInTheHeader_Positive() {
        System.out.println("Позитивный тест запущен");
        orderPage.clickOrderButton();
        orderPage.fillFirstStepOfOrderForm(name, lastName, address, phone);
        orderPage.fillSecondStepOfOrderForm(date, rentalTime, scooterColor, comment);

        String expected = "Заказ оформлен";
        String actual = orderPage.getFinalOrderStatus();

        assertEquals("Заказ не удалось оформить",expected, actual);

    }

    //тестирование создание заказа через кнопку "Заказать" в центре страницы
    @Test
    public void orderButtonInTheCenter() {
        System.out.println("Тест запущен");
        homePage.scrollDownEnd();
        homePage.clickOrderButtonCenter();
        orderPage.fillFirstStepOfOrderForm(name, lastName, address, phone);
        orderPage.fillSecondStepOfOrderForm(date, rentalTime, scooterColor, comment);

        String expected = "Заказ оформлен";
        String actual = orderPage.getFinalOrderStatus();

        assertEquals("Заказ не удалось оформить",expected, actual);
    }
}



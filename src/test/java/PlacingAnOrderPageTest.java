import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.qascooter.base.BaseTest;
import ru.practicum.qascooter.pages.OrderPage;

import java.time.LocalDate;

@RunWith(Parameterized.class)
public class PlacingAnOrderPageTest extends BaseTest {
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String comment;
    private LocalDate date;
    private String rentalTime;
    private String scooterColor;

    public PlacingAnOrderPageTest(String name, String lastName, String address, String phone, LocalDate date, String rentalTime, String scooterColor, String comment, String browser) {
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

    @Parameterized.Parameters(name = "Проверка заполнения полей ввода в форме заказа: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] checkInputField() {
        return new Object[][]{
                {"Иван", "Иванов", "г. Москва, ул. Ленина, д. 1", "89999999999", LocalDate.now().plusDays(1), "сутки", "black", "Комментарий", "firefox"},
                {"Петр", "Петров", "Адресный адрес 1", "89419856578", LocalDate.now().plusDays(2), "двое суток", "grey", "трулала трулаленд", "firefox"},
                {"dfghjkl678i", "fghjk789*", "fghjk34rf 1", "-+664151h%#", LocalDate.now().plusDays(555), "много", "red", "№;%:?*()", "firefox"},//ввод некорректных данных
        };
    }
//тестирование создание заказа через кнопку "Заказать" в шапке сайта
    @Test
    public void orderButtonInTheHeader() {
        System.out.println("Тест запущен");
        orderPage.clickOrderButton();
        orderPage.fillFirstStepOfOrderForm(name, lastName, address, phone);
        orderPage.fillSecondStepOfOrderForm(date, rentalTime, scooterColor, comment);

    }
    //тестирование создание заказа через кнопку "Заказать" в центре страницы
    @Test
    public void orderButtonInTheCenter() {
        System.out.println("Тест запущен");


    }
}



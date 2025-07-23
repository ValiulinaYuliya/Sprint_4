import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.qascooter.base.BaseTest;
import ru.practicum.qascooter.pages.OrderPage;

@RunWith(Parameterized.class)
public class PlacingAnOrderPageTest extends BaseTest {
    protected OrderPage orderPage;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String comment;

    public PlacingAnOrderPageTest(String name, String lastName, String address, String phone, String comment, String browser) {
        super(browser);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    //проверка заполнения полей ввода в форме заказа

    @Parameterized.Parameters(name = "Проверка заполнения полей ввода в форме заказа: {0} {1} {2} {3} {4}")
    public static Object[][] checkInputField() {
        return new Object[][]{
                {"Иван", "Иванов", "г. Москва, ул. Ленина, д. 1", "89999999999", "Комментарий"},
                {"Петр", "Петров", "Адресный адрес 1", "89419856578", "трулала трулаленд"},
                {"dfghjkl678i", "fghjk789*", "fghjk34rf 1", "-+664151h%#", "№;%:?*()"},//ввод некорректных данных
        };
    }
//тестирование создание заказа через кнопку "Заказать" в шапке сайта
    @Test
    public void orderButtonInTheHeader() {
        System.out.println("Тест запущен");

    }
    //тестирование создание заказа через кнопку "Заказать" в центре страницы
    @Test
    public void orderButtonInTheCenter() {
        System.out.println("Тест запущен");


    }
}



package ru.practicum.qascooter.base;

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
public class PlacingAnOrderPageNegativeTest extends BaseTest {

    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String comment;
    private LocalDate date;
    private String rentalTime;
    private String scooterColor;

    public PlacingAnOrderPageNegativeTest(String name, String lastName, String address, String phone, LocalDate date, String rentalTime, String scooterColor, String comment, String browser) {
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

    @Parameterized.Parameters(name = "Негативный тест: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] checkInputFieldNegative() {
        return new Object[][]{
                {"dfghjkl678i", "fghjk789*", "fghjk34rf 1", "-+664151h%#", LocalDate.now().minusDays(0), "много", "red", "№;%:?*()", "firefox"},
                {"tyguuy880=", "qqq789*", "werttrf 1", "-+h%#", LocalDate.now().minusDays(1010), "rere", "red", "№;%:?*()", "chrome"}//ввод некорректных данных
        };
    }

    @Test
    public void orderButtonInTheHeader_Negative() {
        System.out.println("Негативный тест запущен");
        orderPage.clickOrderButton();
        orderPage.fillFirstStepOfOrderForm(name, lastName, address, phone);

        // Не должно быть модального окна "Заказ оформлен"
        try {
            WebElement modalWindow = driver.findElement(By.className("Order_ModalHeader__3FDaJ"));
            fail("Модальное окно 'Заказ оформлен' не должно отображаться");
        } catch (Exception e) {
            // Ожидаемое исключение
        }
    }

    //тестирование создание заказа через кнопку "Заказать" в центре страницы
    @Test
    public void orderButtonInTheCenter_Negative() {
        System.out.println("Негативный тест запущен");
        homePage.scrollDownEnd();
        homePage.clickOrderButtonCenter();
        orderPage.fillFirstStepOfOrderForm(name, lastName, address, phone);

        try {
            WebElement modalWindow = driver.findElement(By.className("Order_ModalHeader__3FDaJ"));
            fail("Модальное окно 'Заказ оформлен' не должно отображаться");
        } catch (Exception e) {
            // Ожидаемое исключение
        }

    }

}
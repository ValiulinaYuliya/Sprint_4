package ru.practicum.qascooter.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //локаторы
    static final By ORDER_BUTTON_HEADER = By.xpath(".//div[2]/button[1]");//кнопка "Заказать" в шапке
    private static final By inputName = By.cssSelector("input[@placeholder='* Имя']");
    private static final By inputLastName = By.cssSelector("input[@placeholder='* Фамилия']");
    private static final By inputAddress = By.cssSelector("input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By inputMetro = By.cssSelector("input[@placeholder='* Станция метро']");
    private static final By inputPhone = By.cssSelector("input[@placeholder='* Телефон: на него позвонит курьер']");
    static final By NEXT_BUTTON = By.className("Button_Button__ra12g Button_Middle__1CSJM");//кнопка "Далее"
    private static final By inputDate = By.cssSelector("input[@placeholder='* Когда привезти самокат']");
    private static final By inputRentalTime = By.className("Dropdown-control");
    private static final String DROPDOWN_OPTION_XPATH = "//div[@class='Dropdown-option' and normalize-space()='%s']";
    private static final By inputColorScooter1 = By.id("black");
    private static final By inputColorScooter2 = By.id("grey");
    private static final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    static final By ORDER_BUTTON_RENT = By.xpath(".//div[3]/button[2]");//кнопка "Заказать" на втором шаге формы
    static final By ORDER_BUTTON_YES = By.xpath("//*[@id='root']//button[contains(text(), 'Да')]");//кнопка "Да"
    private static final By FINAL_ORDER_STATUS = By.className("Order_ModalHeader__3FDaJ");//финальный статус заказа
    static final By FINAL_ORDER_BUTTON = By.xpath(".//div[2]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//кнопка "Посмотреть статус"

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //методы для работы с формой заказа
    public void clickOrderButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON_HEADER));
        driver.findElement(ORDER_BUTTON_HEADER).click();
    }

    public void inputName(String name) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputName));
        field.sendKeys(name);
    }

    public void inputLastName(String lastName) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputLastName));
        field.sendKeys(lastName);
    }

    public void inputAddress(String address) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputAddress));
        field.sendKeys(address);
    }

    public void selectMetro(int metroIndex) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputMetro));
        field.click();
        for (int i = 0; i < metroIndex; i++) {
            driver.findElement(inputMetro).sendKeys(Keys.DOWN);
        }
        driver.findElement(inputMetro).sendKeys(Keys.ENTER);
    }

    public void inputPhone(String phone) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputPhone));
        field.sendKeys(phone);
    }

    public void clickNextButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        button.click();
    }

    //метод заполнения формы заказа на первом шаге
    public void fillFirstStepOfOrderForm(String name, String lastName, String address, int metroIndex, String phone) {
        inputName(name);
        inputLastName(lastName);
        inputAddress(address);
        selectMetro(3);
        inputPhone(phone);
        clickNextButton();
    }

    public void inputDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);

        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputDate));
        field.clear();
        field.sendKeys(formattedDate);
    }

    public void inputRentalTime(String rentalTime) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputRentalTime));
        field.click();

        String xpath = String.format(DROPDOWN_OPTION_XPATH, rentalTime);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();
    }

    private void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void selectColorScooter(String color) {
        if (color.equalsIgnoreCase("black")) {
            click(inputColorScooter1);
        } else if (color.equalsIgnoreCase("grey")) {
            click(inputColorScooter2);
        } else {
            throw new IllegalArgumentException("Неверный цвет самоката: " + color);
        }
    }


    public void inputComment(String comment) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(inputComment));
        field.sendKeys(comment);
    }

    public void clickOrderButtonRent() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON_RENT));
        button.click();
    }

    public void clickOrderButtonYes() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON_YES));
        button.click();
    }

    //метод заполнения формы заказа на втором шаге
    public void fillSecondStepOfOrderForm(LocalDate date, String rentalTime, String scooterColor, String comment) {
        if (date != null) {
            inputDate(date);
        }
        inputRentalTime(rentalTime);
        selectColorScooter(scooterColor);
        inputComment(comment);

        clickOrderButtonRent();
        clickOrderButtonYes();

    }

    //метод получения статуса заказа
    public String getFinalOrderStatus() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));

        try {
            WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(FINAL_ORDER_STATUS));
            String statusText = statusElement.getText();
            if (statusText.contains("Заказ оформлен")) {
                return statusText;
            } else {
                System.out.println("Статус заказа не соответствует ожидаемому" + statusText);
                return "Статус не соответствует ожидаемому: " + statusText;
            }
        } catch (TimeoutException e) {
            System.out.println("Ошибка: Модальное окно не найдено");
            return "Заказ не оформлен, модальное окно не найдено";
        }
    }
}


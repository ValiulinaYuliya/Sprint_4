package ru.practicum.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {
    final WebDriver driver;
    static final By ORDER_BUTTON_HEADER = By.xpath(".//div[2]/button[1]");
    private static final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private static final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    static final By NEXT_BUTTON = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    private static final By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By inputRentalTime = By.className("Dropdown-control");
    private static final By selectRentalTime = By.className("Dropdown-menu");
    private static final By textColorScooter = By.className("Order_Title__3EKne");
    private static final By inputColorScooter1 = By.xpath(".//*[@id='black']");
    private static final By inputColorScooter2 = By.xpath(".//*[@id='grey']");
    private static final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    static final By ORDER_BUTTON_RENT = By.xpath(".//div[3]/button[2]");
    static final By ORDER_BUTTON_YES = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    private static final By FINAL_ORDER_STATUS = By.className("Order_ModalHeader__3FDaJ");
    static final By FINAL_ORDER_BUTTON = By.xpath(".//div[2]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        this.driver.findElement(ORDER_BUTTON_HEADER).click();
    }

    public void inputName(String name) {
        this.driver.findElement(inputName).click();
        this.driver.findElement(inputName).sendKeys(new CharSequence[]{name});
    }

    public void inputLastName(String lastName) {
        this.driver.findElement(inputLastName).click();
        this.driver.findElement(inputLastName).sendKeys(new CharSequence[]{lastName});
    }

    public void inputAddress(String address) {
        this.driver.findElement(inputAddress).click();
        this.driver.findElement(inputAddress).sendKeys(new CharSequence[]{address});
    }

    public void selectMetro(int n) {
        this.driver.findElement(inputMetro).click();

        for(int i = 0; i < n; ++i) {
            this.driver.findElement(inputMetro).sendKeys(new CharSequence[]{Keys.DOWN});
        }

        this.driver.findElement(inputMetro).sendKeys(new CharSequence[]{Keys.ENTER});
    }

    public void inputPhone(String phone) {
        this.driver.findElement(inputPhone).click();
        this.driver.findElement(inputPhone).sendKeys(new CharSequence[]{phone});
    }

    public void clickNext() {
        this.driver.findElement(NEXT_BUTTON).click();
    }

    public void inputOrderPage1(String name, String lastName, String address, String phone) {
        this.inputName(name);
        this.inputLastName(lastName);
        this.inputAddress(address);
        this.selectMetro(3);
        this.inputPhone(phone);
        this.clickNext();
    }

    public void inputDate() {
        LocalDate today = LocalDate.now().plusDays(1L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateString = today.format(formatter);
        this.driver.findElement(inputDate).sendKeys(new CharSequence[]{dateString});
    }

    public void inputDate2() {
        LocalDate today = LocalDate.now().plusDays(7L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateString2 = today.format(formatter);
        this.driver.findElement(inputDate).sendKeys(new CharSequence[]{dateString2});
    }

    public void inputRentalTime(String rentalTime) {
        this.driver.findElement(inputRentalTime).click();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectRentalTime));
        String xpath = String.format("//div[@class='Dropdown-option' and normalize-space()='%s']", rentalTime);
        WebElement option = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();
    }

    public void inputColorScooter1() {
        this.driver.findElement(textColorScooter).getText();
        this.driver.findElement(inputColorScooter1).click();
    }

    public void inputColorScooter2() {
        this.driver.findElement(textColorScooter).getText();
        this.driver.findElement(inputColorScooter2).click();
    }

    public void inputComment(String comment) {
        this.driver.findElement(inputComment).click();
        this.driver.findElement(inputComment).sendKeys(new CharSequence[]{comment});
    }

    public void clickOrderButtonRent() {
        this.driver.findElement(ORDER_BUTTON_RENT).click();
    }

    public void clickOrderButtonYes() {
        this.driver.findElement(ORDER_BUTTON_YES).click();
    }

    public String inputOrderPage2(String comment) {
        this.inputDate();
        String rentalTime = "";
        this.inputRentalTime(rentalTime);
        this.inputColorScooter1();
        this.inputComment(comment);
        this.clickOrderButtonRent();
        this.clickOrderButtonYes();
        return this.checkFinalOrderStatus();
    }

    public Object inputOrderPage3(String comment) {
        this.inputDate2();
        String rentalTime = "";
        this.inputRentalTime(rentalTime);
        this.inputColorScooter2();
        this.inputComment(comment);
        this.clickOrderButtonRent();
        this.clickOrderButtonYes();
        return this.checkFinalOrderStatus();
    }

    public String checkFinalOrderStatus() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        if (this.driver.findElement(FINAL_ORDER_BUTTON).isDisplayed()) {
            WebElement statusElement = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(FINAL_ORDER_STATUS));
            return statusElement.getText();
        } else {
            System.out.println("Заказ не оформлен, кнопка Да не работает");
            return "Заказ не оформлен, кнопка Да не работает";
        }
    }
}


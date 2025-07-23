package ru.practicum.qascooter.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;

    // локаторы
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By ORDER_BUTTON_HEADER = By.xpath(".//*[@id='root']/div/div/div[1]/div[2]/button[1]");//кнопка "Заказать" в шапке
    private static final By ORDER_STATUS_BUTTON = By.cssSelector(".Header_Link__1TAG7");//кнопка "Статус заказа" в шапке
    private static final By SCOOTER_LOGO = By.cssSelector(".Header_Logo__23yGT");//логотип Скутера
    private static final By LOGO_YANDEX = By.cssSelector(".Header_LogoYandex__3TSOI");//логотип Яндекс
    private static final By INPUT_NUMBER_ORDER = By.cssSelector(".Input_Input__1iN_Z Header_Input__xIoUq");//поле ввода номера заказа
    private static final By BUTTON_GO = By.cssSelector(".Button_Button__ra12g Header_Button__28dPO");//кнопка "Go!"
    private static final By ORDER_BUTTON_CENTER = By.xpath("//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");//кнопка "Заказать" в центре страницы
    private static final String QUESTION_SELECTOR = "div.accordion__item:nth-child(%d) > div > div.accordion__button";//локатор для нажатия на вопрос
    private static final String ANSWER_SELECTOR = "div.accordion__item:nth-child(%d) .accordion__panel p";//локатор для получения ответа
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");//кнопка принятия куки

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    /**
     * Получает элемент вопроса по его номеру.
     *
     * @param questionNumber Номер вопроса
     * @return Элемент вопроса
     */
    private WebElement getQuestionElement(int questionNumber) {
        String cssSelector = String.format(QUESTION_SELECTOR, questionNumber);
        By locator = By.cssSelector(cssSelector);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Получает элемент ответа по его номеру.
     *
     * @param questionNumber Номер вопроса
     * @return Элемент ответа
     */
    private WebElement getAnswerElement(int questionNumber) {
        String cssSelector = String.format(ANSWER_SELECTOR, questionNumber);
        By locator = By.cssSelector(cssSelector);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Кликает по вопросу в FAQ по его порядковому номеру.
     *
     * @param questionNumber Номер вопроса (начиная с 1)
     */
    public void clickQuestionButton(int questionNumber) {
        String cssSelector = String.format(QUESTION_SELECTOR, questionNumber);
        By locator = By.cssSelector(cssSelector);
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(locator));
        question.click();
        logger.info("Кликнули по вопросу #{}", questionNumber);
    }

    /**
     * Возвращает текст ответа по его порядковому номеру.
     *
     * @param questionNumber Номер вопроса (начиная с 1)
     * @return Текст ответа
     */
    public String getAnswerText(int questionNumber) {
        String cssSelector = String.format(ANSWER_SELECTOR, questionNumber);
        By locator = By.cssSelector(cssSelector);
        WebElement answerElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return answerElement.getText();
    }

    //Открытие страницы в браузере
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderButtonHeader() {
        driver.findElement(ORDER_BUTTON_HEADER).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(ORDER_STATUS_BUTTON).click();
    }

    public void clickFieldNumberOrder() {
        driver.findElement(INPUT_NUMBER_ORDER).click();
    }

    public void clickButtonGo() {
        driver.findElement(BUTTON_GO).click();
    }

    public void clickLogoYandex() {
        driver.findElement(LOGO_YANDEX).click();
    }

    public void clickLogoScooter() {
        driver.findElement(SCOOTER_LOGO).click();
    }

    public void clickOrderButtonCenter() {
        driver.findElement(ORDER_BUTTON_CENTER).click();
    }


    /**
     * Прокручивает страницу до конца.
     */
    public void scrollDownEnd() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        logger.info("Прокрутили страницу до конца");
    }


    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }
}

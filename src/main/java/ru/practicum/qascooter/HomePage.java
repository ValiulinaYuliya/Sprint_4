package ru.practicum.qascooter;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By ORDER_BUTTON_HEADER = By.xpath(".//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    private static final By ORDER_STATUS_BUTTON = By.cssSelector(".Header_Link__1TAG7");
    private static final By SCOOTER_LOGO = By.cssSelector(".Header_Logo__23yGT");
    private static final By LOGO_YANDEX = By.cssSelector(".Header_LogoYandex__3TSOI");
    private static final By INPUT_NUMBER_ORDER = By.cssSelector(".Input_Input__1iN_Z Header_Input__xIoUq");
    private static final By BUTTON_GO = By.cssSelector(".Button_Button__ra12g Header_Button__28dPO");
    private static final By TEXT_ABOVE_LOGO = By.cssSelector(".Header_Disclaimer__3VEni");
    private static final By ORDER_BUTTON_CENTER = By.xpath("//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");
    private static final By BLOCK_QUESTIONS = By.xpath(".//*[@id='root']/div/div[1]/div[5]/div[1]");
    private static final By QUESTIONS_ANSWER = By.cssSelector(".Home_FAQ__3uVm4");
    private static final By QUESTION_1 = By.xpath("//*[@id='accordion__heading-0']");
    private static final By QUESTION_2 = By.xpath("//*[@id='accordion__heading-1']");
    private static final By QUESTION_3 = By.xpath("//*[@id='accordion__heading-2']");
    private static final By QUESTION_4 = By.xpath("//*[@id='accordion__heading-3']");
    private static final By QUESTION_5 = By.xpath("//*[@id='accordion__heading-4']");
    private static final By QUESTION_6 = By.xpath("//*[@id='accordion__heading-5']");
    private static final By QUESTION_7 = By.xpath("//*[@id='accordion__heading-6']");
    private static final By QUESTION_8 = By.xpath("//*[@id='accordion__heading-7']");
    private static final By ANSWER_1 = By.xpath(".//*[@id='accordion__panel-0']");
    private static final By ANSWER_2 = By.xpath(".//*[@id='accordion__panel-1']");
    private static final By ANSWER_3 = By.xpath(".//*[@id='accordion__panel-2']");
    private static final By ANSWER_4 = By.xpath(".//*[@id='accordion__panel-3']");
    private static final By ANSWER_5 = By.xpath(".//*[@id='accordion__panel-4']");
    private static final By ANSWER_6 = By.xpath(".//*[@id='accordion__panel-5']");
    private static final By ANSWER_7 = By.xpath(".//*[@id='accordion__panel-6']");
    private static final By ANSWER_8 = By.xpath(".//*[@id='accordion__panel-7']");
    private static final By COOKIE_CONTENT = By.className("App_CookieConsent__1yUIN");
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderButtonHeader() {
        this.driver.findElement(ORDER_BUTTON_HEADER).click();
    }

    public void clickOrderStatusButton() {
        this.driver.findElement(ORDER_STATUS_BUTTON).click();
    }

    public void clickFieldNumberOrder() {
        this.driver.findElement(INPUT_NUMBER_ORDER).click();
    }

    public void clickButtonGo() {
        this.driver.findElement(BUTTON_GO).click();
    }

    public void clickLogoYandex() {
        this.driver.findElement(LOGO_YANDEX).click();
    }

    public void clickLogoScooter() {
        this.driver.findElement(SCOOTER_LOGO).click();
    }

    public String getTextAboveLogo() {
        return this.driver.findElement(TEXT_ABOVE_LOGO).getText();
    }

    public void scrollDownWork() {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{this.driver.findElement(ORDER_BUTTON_CENTER)});
    }

    public void clickOrderButtonCenter() {
        this.driver.findElement(ORDER_BUTTON_CENTER).click();
    }

    public String getTextBlockQuestions() {
        return this.driver.findElement(BLOCK_QUESTIONS).getText();
    }

    public void scrollDownEnd() {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{this.driver.findElement(QUESTIONS_ANSWER)});
    }

    public void clickQuestions1() {
        this.driver.findElement(QUESTION_1).click();
    }

    public String getTextAnswer1() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_1))).getText().trim();
    }

    public void clickQuestions2() {
        this.driver.findElement(QUESTION_2).click();
    }

    public String getTextAnswer2() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_2))).getText().trim();
    }

    public void clickQuestions3() {
        this.driver.findElement(QUESTION_3).click();
    }

    public String getTextAnswer3() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_3))).getText().trim();
    }

    public void clickQuestions4() {
        this.driver.findElement(QUESTION_4).click();
    }

    public String getTextAnswer4() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_4))).getText().trim();
    }

    public void clickQuestions5() {
        this.driver.findElement(QUESTION_5).click();
    }

    public String getTextAnswer5() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_5))).getText().trim();
    }

    public void clickQuestions6() {
        this.driver.findElement(QUESTION_6).click();
    }

    public String getTextAnswer6() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_6))).getText().trim();
    }

    public void clickQuestions7() {
        this.driver.findElement(QUESTION_7).click();
    }

    public String getTextAnswer7() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_7))).getText().trim();
    }

    public void clickQuestions8() {
        this.driver.findElement(QUESTION_8).click();
    }

    public String getTextAnswer8() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        return ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(ANSWER_8))).getText().trim();
    }

    public String getTextCookie() {
        return this.driver.findElement(COOKIE_CONTENT).getText();
    }

    public void clickCookieButton() {
        this.driver.findElement(COOKIE_BUTTON).click();
    }
}

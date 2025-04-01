package praktikum.sprint4;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class MainPage {

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    //адрес страницы
    private static final String url = "https://qa-scooter.praktikum-services.ru/";
    //кнопка про куки
    private final By cookiesButton = By.className("App_CookieButton__3cvqF");
    //верхняя кнопка "Заказать"
    private final By orderButtonUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //нижняя кнопка "Заказать"
    private final By orderButtonDown = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //раздел FAQ
    private final By FAQ = By.xpath(".//div[@class = 'Home_FourPart__1uthg']");

    //открытие страницы
    public MainPage openOrderPage() {
        webDriver.get(url);
        return this;
    }

    //клик по кнопке про куки
    public MainPage clickCookiesButton() {
        webDriver.findElement(cookiesButton).click();
        return this;
    }

    //клик по верхней кнопке "Заказать"
    public MainPage clickOrderButtonUp() {
        webDriver.findElement(orderButtonUp).click();
        return this;
    }

    //клик по нижней кнопке "Заказать"
    public MainPage clickOrderButtonDown() {
        webDriver.findElement(orderButtonDown).click();
        return this;
    }

    //скролл до последнего элемента FAQ
    public MainPage scroll() {
        WebElement element = webDriver.findElement(FAQ);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //универсальный метод для получения текста вопросов с ожиданием
    public String getUniversalTextFromElement(int number) {
        By questionText = By.id("accordion__panel-" + number);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(questionText));
        return element.getText();
    }

    //универсальный метод для клика по вопросу
    public MainPage clickUniversalQuestionFromElement(int num) {
        By questionButton = By.id("accordion__heading-" + num);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(questionButton))
                .click();
        return this;
    }

}

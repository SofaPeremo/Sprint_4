package praktikum.sprint4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPageTwo {

    private WebDriver webDriver;

    public OrderPageTwo(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //поле начала аренды
    private final By deliveryDateInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //выбор дня в календаре 06.04.2025
    private final By datepickerChooseDropdownForTestOne = By.xpath(".//div[@aria-label = 'Choose воскресенье, 6-е апреля 2025 г.']");
    //выбор дня в календаре 27.04.2025
    private final By datepickerChooseDropdownForTestTwo = By.xpath(".//div[@aria-label = 'Choose воскресенье, 27-е апреля 2025 г.']");
    //поле срока аренды
    private final By rentalPeriodInput = By.xpath(".//div[@class = 'Dropdown-control']");
    //выпадающий список дней аренды
    private final By amountOfDaysDropdown = By.xpath(".//div[@class = 'Dropdown-menu']/div[4]");
    //цвет самоката черный
    private final By scooterColorBlackCheckbox = By.xpath(".//label[@for = 'black']");
    //цвет самоката серый
    private final By scooterColorGreyCheckbox = By.xpath(".//label[@for = 'grey']");
    //поле ввода комментария для курьера
    private final By commentInput = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //кнопка "Заказать" под формой
    private final By orderButtonDown = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[2]");
    //кнопка "Да" на модалке подтверждения заказа
    private final By confirmTheOrderButton = By.xpath(".//button[contains(text(), 'Да')]");
    //модалка успешно оформленного заказа
    private final By successfulOrderModal = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");


    //кликнуть по полю начала аренды
    public OrderPageTwo clickDeliveryDateInput() {
        webDriver.findElement(deliveryDateInput).click();
        return this;
    }

    //выбрать дату в календаре для первого теста
    public OrderPageTwo clickDatepickerChooseDropdownForTestOne() {
        webDriver.findElement(datepickerChooseDropdownForTestOne).click();
        return this;
    }

    //выбрать дату в календаре для первого теста
    public OrderPageTwo clickDatepickerChooseDropdownForTestTwo() {
        webDriver.findElement(datepickerChooseDropdownForTestTwo).click();
        return this;
    }

    //клик по полю со сроком аренды
    public OrderPageTwo clickRentalPeriodInput() {
        webDriver.findElement(rentalPeriodInput).click();
        return this;
    }

    //клик по количеству дней адренды из списка
    public OrderPageTwo clickAmountOfDaysDropdown() {
        webDriver.findElement(amountOfDaysDropdown).click();
        return this;
    }

    //выбрать цвет черный
    public OrderPageTwo clickScooterColorBlack() {
        webDriver.findElement(scooterColorBlackCheckbox).click();
        return this;
    }

    //выбрать цвет серый
    public OrderPageTwo clickScooterColorGrey() {
        webDriver.findElement(scooterColorGreyCheckbox).click();
        return this;
    }

    //ввести комментарий для курьера
    public OrderPageTwo printComment(String comment) {
        webDriver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    //клик по кнопке Заказать под формой
    public OrderPageTwo clickOrderButtonDown() {
        webDriver.findElement(orderButtonDown).click();
        return this;
    }

    //клик по кнопке подтверждения заказа
    public OrderPageTwo clickConfirmTheOrderButton() {
        webDriver.findElement(confirmTheOrderButton).click();
        return this;
    }

    //отображение модалки успешного заказа
    public boolean getModalSuccessfulOrder() {
        return webDriver.findElement(successfulOrderModal).isDisplayed();
    }
}

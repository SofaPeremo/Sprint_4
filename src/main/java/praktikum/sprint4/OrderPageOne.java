package praktikum.sprint4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class OrderPageOne {

    private final WebDriver webDriver;

    public OrderPageOne(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //поле ввода имени
    private final By userNameInput = By.xpath(".//input[@placeholder = '* Имя']");
    //поле ввода фамилии
    private final By userSurnameInput = By.xpath(".//input[@placeholder = '* Фамилия']");
    //поле ввода адреса
    private  final By userAddressInput = By.xpath(".//input[@placeholder= '* Адрес: куда привезти заказ']");
    //поле ввода названия станции метро
    private final By metroDropdown = By.className("select-search__value");
    //выпадающий список станций метро (36 пункт)
    private final By metroStationForTestOneDropdown = By.xpath("//div[@class = 'select-search__select']//button[@value = '36']");
    //выпадающий список станций метро (36 пункт)
    private final By metroStationForTestTwoDropdown = By.xpath("//div[@class = 'select-search__select']//button[@value = '11']");
    //поле ввода номера телефона
    private final By userPhoneInput = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private final By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //ввести значение в поле Имя
    public OrderPageOne printUserName(String userName) {
        webDriver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    //ввести значение в поле Фамилия
    public OrderPageOne printUserSurname(String userSurname) {
        webDriver.findElement(userSurnameInput).sendKeys(userSurname);
        return this;
    }

    //ввести значение в поле Адрес
    public OrderPageOne printUserAddress(String userAddress) {
        webDriver.findElement(userAddressInput).sendKeys(userAddress);
        return this;
    }

    //кликнуть по полю Станция метро
    public OrderPageOne clickMetro() {
        webDriver.findElement(metroDropdown).click();
        return this;
    }

    public OrderPageOne clickMetroStation(String stationType) {
        By stationLocator;
        //выбираем локатор в зависимости от типа станции
        if ("stationOne".equals(stationType)) {
            stationLocator = metroStationForTestOneDropdown;
        } else if ("stationTwo".equals(stationType)) {
            stationLocator = metroStationForTestTwoDropdown;
        } else {
            throw new IllegalArgumentException("Unknown station type: " + stationType);
        }

        //кликаем по выбранной станции
        webDriver.findElement(stationLocator).click();
        return this;
    }

    //ввести значение в поле Телефон
    public OrderPageOne printPhoneNumber(String phoneNumber) {
        webDriver.findElement(userPhoneInput).sendKeys(phoneNumber);
        return this;
    }

    //клик по кнопке Далее
    public OrderPageOne clickNextButton() {
        webDriver.findElement(nextButton).click();
        return this;
    }
}

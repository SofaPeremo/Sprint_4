package praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        //webDriver = new FirefoxDriver();
    }

    private final String buttonType;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String deliveryDate;
    private final String scooterColor;
    private final String comment;

    public OrderTest(String buttonType,
                     String name,
                     String surname,
                     String address,
                     String metroStation,
                     String phone,
                     String deliveryDate,
                     String scooterColor,
                     String comment) {
        this.buttonType = buttonType;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"up", "Иван", "Иванов", "Москва", "stationOne", "89000000000", "date1", "black", "Комментарий для курьера"},
                {"down", "Анна", "Ромашкина", "Санкт-Петербург", "stationTwo", "89111111111", "date2", "grey", "Комментарий для курьера"}
        };
    }

    @Test
    public void testOrderCreation() {
        new MainPage(webDriver)
                .openOrderPage()
                .clickCookiesButton()
                .clickOrderButton(buttonType.equals("up") ? "up" : "down");

        new OrderPageOne(webDriver)
                .printUserName(name)
                .printUserSurname(surname)
                .printUserAddress(address)
                .clickMetro()
                .clickMetroStation(metroStation)
                .printPhoneNumber(phone)
                .clickNextButton();

        new OrderPageTwo(webDriver)
                .clickDeliveryDateInput()
                .chooseDeliveryDate(deliveryDate)
                .clickRentalPeriodInput()
                .clickAmountOfDaysDropdown()
                .clickScooterColor(scooterColor)
                .printComment(comment)
                .clickOrderButtonDown()
                .clickConfirmTheOrderButton();

        boolean isModalDisplayed = new OrderPageTwo(webDriver).getModalSuccessfulOrder();
        assertTrue("Модальное окно успешного заказа не отобразилось", isModalDisplayed);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}

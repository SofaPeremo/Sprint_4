package praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;


public class OrderTest{

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        //webDriver = new FirefoxDriver();
    }

    @Test
    public void orderButtonUp() {

        new MainPage(webDriver)
                .openOrderPage()
                .clickCookiesButton()
                .clickOrderButtonUp();

        new OrderPageOne(webDriver)
                .printUserName("Иван")
                .printUserSurname("Иванов")
                .printUserAddress("Москва")
                .clickMetro()
                .clickMetroStationOne()
                .printPhoneNumber("89000000000")
                .clickNextButton();

        new OrderPageTwo(webDriver)
                .clickDeliveryDateInput()
                .clickDatepickerChooseDropdownForTestOne()
                .clickRentalPeriodInput()
                .clickAmountOfDaysDropdown()
                .clickScooterColorBlack()
                .printComment("Комментарий для курьера")
                .clickOrderButtonDown()
                .clickConfirmTheOrderButton();


        boolean isModalDisplayed = new OrderPageTwo(webDriver).getModalSuccessfulOrder();
        assertTrue("Модальное окно успешного заказа не отобразилось", isModalDisplayed);

    }

    @Test
    public void orderButtonDown() {

        new MainPage(webDriver)
                .openOrderPage()
                .clickCookiesButton()
                .clickOrderButtonDown();

        new OrderPageOne(webDriver)
                .printUserName("Анна")
                .printUserSurname("Ромашкина")
                .printUserAddress("Санкт-Петербург")
                .clickMetro()
                .clickMetroStationTwo()
                .printPhoneNumber("89111111111")
                .clickNextButton();

        new OrderPageTwo(webDriver)
                .clickDeliveryDateInput()
                .clickDatepickerChooseDropdownForTestTwo()
                .clickRentalPeriodInput()
                .clickAmountOfDaysDropdown()
                .clickScooterColorGrey()
                .printComment("Комментарий для курьера")
                .clickOrderButtonDown()
                .clickConfirmTheOrderButton();


        boolean isModalDisplayed = new OrderPageTwo(webDriver).getModalSuccessfulOrder();
        assertTrue("Модальное окно успешного заказа не отобразилось", isModalDisplayed);

    }

    @After
    public void teardown() {
        webDriver.quit();
    }

}

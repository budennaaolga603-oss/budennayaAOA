package Lesson_10;

import Lesson_10.pages.MainPage;
import Lesson_10.pages.PaymentFrame;
import Lesson_9.SeleniumDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MtsPaySectionTest extends BaseTest {

    private WebDriver driver = SeleniumDriver.getInstance();
    private MainPage mainPage;

    @BeforeEach
    public void homePage() {
        driver.get("https://www.mts.by/");
        try {
            driver.findElement(By.id("cookie-agree")).click();
        } catch (Exception e) {
        }
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkSectionTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getSectionTitle());
    }

    @Test
    public void checkPaymentLogos() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        assertFalse(logos.isEmpty());
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void checkMoreInfoLink() {
        mainPage.clickMoreInfoLink();
        assertEquals(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                mainPage.getCurrentUrl());
    }

    @Test
    public void checkConnectionFormPlaceholders() {
        assertEquals("Номер телефона", mainPage.getConnectionPhonePlaceholder());
        assertEquals("Сумма", mainPage.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getConnectionEmailPlaceholder());
    }

    @Test
    public void checkInternetFormPlaceholders() {
        mainPage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getInternetPhonePlaceholder());
        assertEquals("Сумма", mainPage.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getInternetEmailPlaceholder());
    }

    @Test
    public void checkInstalmentFormPlaceholders() {
        mainPage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getInstalmentScorePlaceholder());
        assertEquals("Сумма", mainPage.getInstalmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getInstalmentEmailPlaceholder());
    }

    @Test
    public void checkArrearsFormPlaceholders() {
        mainPage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getArrearsScorePlaceholder());
        assertEquals("Сумма", mainPage.getArrearsSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getArrearsEmailPlaceholder());
    }

    @Test
    public void checkPaymentFrameDetails() {
        PaymentFrame frame = mainPage.fillConnectionFormAndSubmit(
                "297777777", "158", "email@mail.ru");
        assertTrue(frame.getAmountText().contains("158"));
        assertTrue(frame.getAmountButtonText().contains("158"));
        assertTrue(frame.getPhoneText().contains("375297777777"));
        assertEquals("Номер карты", frame.getCardNumberPlaceholder());
        assertEquals("Срок действия", frame.getCardExpiryPlaceholder());
        assertEquals("CVC", frame.getCardCvcPlaceholder());
        assertEquals("Имя и фамилия на карте", frame.getCardHolderPlaceholder());
        List<WebElement> icons = frame.getPaymentIcons();
        assertFalse(icons.isEmpty());
        frame.switchBack();
    }
}
package Lesson_11;

import Lesson_10.pages.MainPage;
import Lesson_10.pages.PaymentFrame;
import Lesson_9.SeleniumDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

//Верхний уровень группировки в Allure - соответствует крупному модулю или разделу приложения
@Epic("МТС Беларусь")
//Функциональность внутри Epic - соответствует конкретной фиче которую тестируем
@Feature("Онлайн оплата")
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
    @Story("Заголовок блока оплаты")
    @DisplayName("Проверка заголовка блока «Онлайн пополнение без комиссии»")
    @Description("Открываем mts.by и проверяем что заголовок блока оплаты содержит правильный текст")
    @Severity(SeverityLevel.NORMAL)
    public void checkSectionTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getSectionTitle());
    }

    @Test
    @Story("Логотипы платёжных систем")
    @DisplayName("Проверка наличия логотипов платёжных систем")
    @Description("Проверяем что все логотипы платёжных систем присутствуют и отображаются")
    @Severity(SeverityLevel.NORMAL)
    public void checkPaymentLogos() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        assertFalse(logos.isEmpty());
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    @Story("Ссылка «Подробнее о сервисе»")
    @DisplayName("Проверка ссылки «Подробнее о сервисе»")
    @Description("Кликаем на ссылку и проверяем что открывается нужная страница")
    @Severity(SeverityLevel.MINOR)
    public void checkMoreInfoLink() {
        mainPage.clickMoreInfoLink();
        assertEquals(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                mainPage.getCurrentUrl());
    }

    @Test
    @Story("Плейсхолдеры полей форм")
    @DisplayName("Проверка плейсхолдеров формы «Услуги связи»")
    @Description("Проверяем текст в незаполненных полях формы Услуги связи")
    @Severity(SeverityLevel.NORMAL)
    public void checkConnectionFormPlaceholders() {
        assertEquals("Номер телефона", mainPage.getConnectionPhonePlaceholder());
        assertEquals("Сумма", mainPage.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getConnectionEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры полей форм")
    @DisplayName("Проверка плейсхолдеров формы «Домашний интернет»")
    @Description("Выбираем Домашний интернет и проверяем текст в незаполненных полях")
    @Severity(SeverityLevel.NORMAL)
    public void checkInternetFormPlaceholders() {
        mainPage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getInternetPhonePlaceholder());
        assertEquals("Сумма", mainPage.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getInternetEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры полей форм")
    @DisplayName("Проверка плейсхолдеров формы «Рассрочка»")
    @Description("Выбираем Рассрочка и проверяем текст в незаполненных полях")
    @Severity(SeverityLevel.NORMAL)
    public void checkInstalmentFormPlaceholders() {
        mainPage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getInstalmentScorePlaceholder());
        assertEquals("Сумма", mainPage.getInstalmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getInstalmentEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры полей форм")
    @DisplayName("Проверка плейсхолдеров формы «Задолженность»")
    @Description("Выбираем Задолженность и проверяем текст в незаполненных полях")
    @Severity(SeverityLevel.NORMAL)
    public void checkArrearsFormPlaceholders() {
        mainPage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getArrearsScorePlaceholder());
        assertEquals("Сумма", mainPage.getArrearsSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getArrearsEmailPlaceholder());
    }

    @Test
    @Story("Форма оплаты в iframe")
    @DisplayName("Проверка данных в окне оплаты после нажатия «Продолжить»")
    @Description("Заполняем форму Услуги связи, нажимаем Продолжить и проверяем iframe: сумма, телефон, поля карты, иконки")
    @Severity(SeverityLevel.CRITICAL)
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
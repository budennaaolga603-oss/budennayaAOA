package Lesson_9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MtsPaySectionTest extends BaseTest {

    private WebDriver driver = SeleniumDriver.getInstance();

    @BeforeEach
    public void homePage() {
        driver.get("https://www.mts.by/");
    }

    //Проверить название указанного блока;
    @Test
    public void checkSectionTitle() {
        WebElement title = driver.findElement(
                By.xpath("//section[@class='pay']//h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    // Проверить наличие логотипов платёжных систем;
    @Test
    public void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(
                By.xpath("//div[@class='pay__partners']//img"));
        assertFalse(logos.isEmpty());
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    //Проверить работу ссылки «Подробнее о сервисе»;
    @Test
    public void checkMoreInfoLink() {
        WebElement link = driver.findElement(
                By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        link.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    //Заполнить поля и проверить работу кнопки «Продолжить»
    @Test
    public void checkContinueButton() {
        try {
            WebDriverWait waitCookie = new WebDriverWait(driver, 3);
            WebElement cookie = waitCookie.until(ExpectedConditions.elementToBeClickable(
                    By.id("cookie-agree")));
            cookie.click();
        } catch (Exception e) {
        }
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        phoneField.sendKeys("297777777");
        sumField.sendKeys("158");
        WebElement continueButton = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe")));
        assertNotNull(iframe);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe")));
        driver.switchTo().defaultContent();
    }
}
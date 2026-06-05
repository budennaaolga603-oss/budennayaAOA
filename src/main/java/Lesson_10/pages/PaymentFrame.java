package Lesson_10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class PaymentFrame {

    private WebDriver driver;
    private WebDriverWait wait;

    //Локаторы элементов внутри iframe
    private By amountText = By.xpath("//div[contains(@class,'pay-description__cost')]//span");
    private By amountButton = By.xpath("//button[contains(@class,'colored')]");
    private By phoneText = By.xpath("//*[contains(@class,'pay-description__text')]");
    private By cardNumberPlaceholder = By.xpath("//input[@id='cc-number']");
    private By cardExpiryPlaceholder = By.xpath("//input[contains(@class,'date-input')]");
    private By cardCvcPlaceholder = By.xpath("//input[@formcontrolname='cvc']");
    private By cardHolderPlaceholder = By.xpath("//input[@formcontrolname='holder']");
    private By paymentIcons = By.xpath("//div[contains(@class,'cards-brands__container')]//img");

    public PaymentFrame(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getAmountText() {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(amountText));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].textContent;", el);
    }

    public String getAmountButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountButton)).getText();
    }

    public String getPhoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneText)).getText();
    }

    public String getCardNumberPlaceholder() {
        return driver.findElement(By.xpath("//input[@id='cc-number']/following-sibling::label")).getText();
    }

    public String getCardExpiryPlaceholder() {
        return driver.findElement(By.xpath("//input[contains(@class,'date-input')]/following-sibling::label")).getText();
    }

    public String getCardCvcPlaceholder() {
        return driver.findElement(By.xpath("//input[@formcontrolname='cvc']/following-sibling::label")).getText();
    }

    public String getCardHolderPlaceholder() {
        return driver.findElement(By.xpath("//input[@formcontrolname='holder']/following-sibling::label")).getText();
    }

    public List<WebElement> getPaymentIcons() {
        return driver.findElements(paymentIcons);
    }

    //Вернуться из iframe обратно на основную страницу
    public void switchBack() {
        driver.switchTo().defaultContent();
    }
}
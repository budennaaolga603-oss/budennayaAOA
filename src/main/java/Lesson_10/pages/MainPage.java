package Lesson_10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Локаторы блока «Онлайн пополнение без комиссии»
    private By sectionTitle = By.xpath("//section[@class='pay']//h2");
    private By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private By moreInfoLink = By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");

    //Локаторы формы «Услуги связи»
    private By connectionPhone = By.id("connection-phone");
    private By connectionSum = By.id("connection-sum");
    private By connectionEmail = By.id("connection-email");
    private By connectionButton = By.xpath("//form[@class='pay-form opened']//button[@type='submit']");

    //Локаторы формы «Домашний интернет»
    private By internetPhone = By.id("internet-phone");
    private By internetSum = By.id("internet-sum");
    private By internetEmail = By.id("internet-email");

    //Локаторы формы «Рассрочка»
    private By instalmentScore = By.id("score-instalment");
    private By instalmentSum = By.id("instalment-sum");
    private By instalmentEmail = By.id("instalment-email");

    //Локаторы формы «Задолженность»
    private By arrearsScore = By.id("score-arrears");
    private By arrearsSum = By.id("arrears-sum");
    private By arrearsEmail = By.id("arrears-email");

    //Локаторы выпадающего списка вариантов оплаты
    private By selectHeader = By.xpath("//button[@class='select__header']");
    private By selectOptions = By.xpath("//ul[@class='select__list']//p[@class='select__option']");

    //Увеличила до 10 секунд из-за медленной загрузки iframe
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getSectionTitle() {
        return driver.findElement(sectionTitle).getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    //Ждём пока URL изменится
    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.not(
                        ExpectedConditions.urlToBe("https://www.mts.by/")
                )
        );
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public String getConnectionPhonePlaceholder() {
        return getPlaceholder(connectionPhone);
    }

    public String getConnectionSumPlaceholder() {
        return getPlaceholder(connectionSum);
    }

    public String getConnectionEmailPlaceholder() {
        return getPlaceholder(connectionEmail);
    }

    public String getInternetPhonePlaceholder() {
        return getPlaceholder(internetPhone);
    }

    public String getInternetSumPlaceholder() {
        return getPlaceholder(internetSum);
    }

    public String getInternetEmailPlaceholder() {
        return getPlaceholder(internetEmail);
    }

    public String getInstalmentScorePlaceholder() {
        return getPlaceholder(instalmentScore);
    }

    public String getInstalmentSumPlaceholder() {
        return getPlaceholder(instalmentSum);
    }

    public String getInstalmentEmailPlaceholder() {
        return getPlaceholder(instalmentEmail);
    }

    public String getArrearsScorePlaceholder() {
        return getPlaceholder(arrearsScore);
    }

    public String getArrearsSumPlaceholder() {
        return getPlaceholder(arrearsSum);
    }

    public String getArrearsEmailPlaceholder() {
        return getPlaceholder(arrearsEmail);
    }

    public void selectPaymentOption(String optionText) {
        driver.findElement(selectHeader).click();
        List<WebElement> options = driver.findElements(selectOptions);
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public PaymentFrame fillConnectionFormAndSubmit(String phone, String sum, String email) {
        driver.findElement(connectionPhone).sendKeys(phone);
        driver.findElement(connectionSum).sendKeys(sum);
        driver.findElement(connectionEmail).sendKeys(email);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(connectionButton));
        button.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
        return new PaymentFrame(driver, wait);
    }
}
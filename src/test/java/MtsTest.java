import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest extends TestBase {
    //1. проверка названия блока
    @Test
    public void testOnlinePaymentBlockTitle() {
        WebElement paymentBlock = driver.findElement(By.className("pay"));
        WebElement titleElement = paymentBlock.findElement(By.xpath(".//h2"));
        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = titleElement.getText().replace("\n", " ").trim();
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
    }

    //2. проверка наличия логотипов платежных систем
    @Test
    public void testLogosOfPaymentSystems() {
        WebElement paymentBlock = driver.findElement(By.className("pay"));
        List<By> paymentLogos = List.of(By.cssSelector("img[alt='Visa']"), By.cssSelector("img[alt='MasterCard']"),
                By.cssSelector("img[alt='Белкарт']"));
        assertEquals(3, paymentLogos.size(), "Должно быть 3 логотипа");
        paymentLogos.forEach(logo -> {
            WebElement logoElement = new WebDriverWait(driver, Duration.ofSeconds(5)).
                    until(ExpectedConditions.visibilityOfElementLocated(logo));
            assertTrue(logoElement.isDisplayed(), "Логотип не отображается: "
                    + logoElement.getAttribute("alt"));
        });
    }

    //3. проверка работы ссылки
    @Test
    public void testLinkLearnMoreAboutService() {
        //принимаем куки
        try {
            WebElement cookieAgreeButton = driver.findElement(By.id("cookie-agree"));
            cookieAgreeButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.invisibilityOf(cookieAgreeButton));
        } catch (NoSuchElementException ignored) {
        }
        //сама проверка
        By linkLocator = By.linkText("Подробнее о сервисе");
        WebElement linkLearnMore = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(linkLocator));
        assertTrue(linkLearnMore.isDisplayed(), "Ссылка \"Подробнее о сервисе\" не отображается");
        String originalUrl = driver.getCurrentUrl();
        linkLearnMore.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    //4. заполнение поля и проверка работы кнопки «Продолжить»
    @Test
    public void testContinueButton() {
        //принимаем куки
        try {
            WebElement cookieAgreeButton = driver.findElement(By.id("cookie-agree"));
            cookieAgreeButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.invisibilityOf(cookieAgreeButton));
        } catch (NoSuchElementException ignored) {
        }
        //заполнение формы и клик на кнопку
        WebElement payFormBlock = driver.findElement(By.id("pay-connection"));
        WebElement phoneInputField = payFormBlock.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = payFormBlock.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("10");
        By buttonLocator = By.xpath("//button[contains(text(), 'Продолжить')]");
        WebElement buttonContinue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> {
                    WebElement button = driver.findElement(buttonLocator);
                    return button.isDisplayed() && button.isEnabled() ? button : null;
                });
        buttonContinue.click();
        //переключение на фрейм
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe")));
        try {
            WebElement newForm = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app-wrapper__content")));
            assertTrue(newForm.isDisplayed(), "Новая форма не отобразилась");
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
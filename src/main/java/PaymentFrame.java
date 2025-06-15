import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentFrame extends BasePage {
    //фрейм и основная форма
    @FindBy(css = "iframe.bepaid-iframe")
    private WebElement frameElement;

    @FindBy(css = ".app-wrapper__content")
    private WebElement frameForm;

    @FindBy(css = ".pay-description__content")
    private WebElement payDescriptionCost;

    @FindBy(xpath = "//span[contains(text(), 'BYN')]")
    private WebElement payCost;

    @FindBy(xpath = "//button[contains(text(), 'Оплатить')]")
    private WebElement buttonSubmitCost;

    @FindBy(css = ".pay-description__text")
    private WebElement payText;

    @FindBy(css = ".pay-description__text")
    private WebElement payDescriptionText;

    //блок оплаты картой
    @FindBy(css = ".card-page__card")
    private WebElement cardFormBlock;

    //лейблы над полями карты
    @FindBy(xpath = "//label[contains(text(), 'Номер карты')]")
    private WebElement cardNumberText;

    @FindBy(xpath = "//label[contains(text(), 'Срок действия')]")
    private WebElement cardValidityPeriodText;

    @FindBy(xpath = "//label[contains(text(), 'CVC')]")
    private WebElement cvcText;

    @FindBy(xpath = "//label[contains(text(), 'Имя и фамилия на карте')]")
    private WebElement nameText;

    //иконки платежных систем
    @FindBy(css = "img[src='assets/images/payment-icons/card-types/visa-system.svg']")
    private WebElement visaIcon;

    @FindBy(css = "img[src='assets/images/payment-icons/card-types/mastercard-system.svg']")
    private WebElement mastercardIcon;

    @FindBy(css = "img[src='assets/images/payment-icons/card-types/belkart-system.svg']")
    private WebElement belkartIcon;

    public PaymentFrame(WebDriver driver) {
        super(driver);
    }

    @Step("Переключиться во фрейм оплаты")
    public void switchToPaymentFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe")));
    }

    @Step("Переключиться в основной контент")
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Step("Проверить отображения формы")
    public boolean isFormDisplayed() {
        return frameForm.isDisplayed();
    }

    @Step("Получить отображаемую сумму")
    public String getPayCost() {
        return payCost.getText();
    }

    @Step("Получить текст с номером")
    public String getPayText() {
        return payText.getText();
    }

    @Step("Получить текст над полем 'Номер карты'")
    public String getCardNumberLabel() {
        return cardNumberText.getText();
    }

    @Step("Получить текст над полем 'Срок действия'")
    public String getCardValidityLabel() {
        return cardValidityPeriodText.getText();
    }

    @Step("Получить текст над полем 'CVC'")
    public String getCvcLabel() {
        return cvcText.getText();
    }

    @Step("Получить текст над полем 'Имя и фамилия на карте'")
    public String getCardNameLabel() {
        return nameText.getText();
    }

    @Step("Проверить наличия иконок платежных систем")
    public boolean isPaymentIconsDisplayed() {
        return visaIcon.isDisplayed() && mastercardIcon.isDisplayed() && belkartIcon.isDisplayed();
    }
}
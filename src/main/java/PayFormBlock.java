import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayFormBlock extends BasePage {
    //выпадающий список типов услуг
    @FindBy(css = ".select__header")
    private WebElement selectHeaderButton;

    @FindBy(css = ".select__list")
    private WebElement selectList;

    //элементы списка
    @FindBy(xpath = "//p[@class='select__option' and contains(text(), 'Домашний интернет')]")
    private WebElement internetOption;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(), 'Рассрочка')]")
    private WebElement instalmentOption;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(), 'Задолженность')]")
    private WebElement arrearsOption;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement buttonContinue;

    //поля ввода
    @FindBy(id = "connection-phone")
    private WebElement connectionPhoneInput;

    @FindBy(id = "connection-sum")
    private WebElement connectionSumInput;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    @FindBy(id = "score-instalment")
    private WebElement instalmentPhoneInput;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumInput;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailInput;

    @FindBy(id = "score-arrears")
    private WebElement arrearsPhoneInput;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumInput;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailInput;

    public PayFormBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Выбрать тип услуги: {serviceType}")
    public PayFormBlock selectServiceType(String type) {
        selectHeaderButton.click();
        wait.until(ExpectedConditions.visibilityOf(selectHeaderButton));
        WebElement optionToClick;
        switch (type.toLowerCase()) {
            case "домашний интернет":
                optionToClick = wait.until(ExpectedConditions.elementToBeClickable(internetOption));
                break;
            case "рассрочка":
                optionToClick = wait.until(ExpectedConditions.elementToBeClickable(instalmentOption));
                break;
            case "задолженность":
                optionToClick = wait.until(ExpectedConditions.elementToBeClickable(arrearsOption));
                break;
            default: //по умолчанию: услуги связи
        }
        wait.until(ExpectedConditions.visibilityOf(selectHeaderButton));
        return this;
    }

    @Step("Заполнить форму: номер — {phone}, сумма — {sum}")
    public PayFormBlock fillForm(String phone, String sum) {
        connectionPhoneInput.sendKeys(phone);
        connectionSumInput.sendKeys(sum);
        return this;
    }

    @Step("Получить placeholder номера телефона для типа: {serviceType}")
    public String getPhoneInputPlaceholder(String serviceType) {
        switch (serviceType) {
            case "connection":
                return connectionPhoneInput.getAttribute("placeholder");
            case "internet":
                return internetPhoneInput.getAttribute("placeholder");
            case "instalment":
                return instalmentPhoneInput.getAttribute("placeholder");
            case "arrears":
                return arrearsPhoneInput.getAttribute("placeholder");
            default:
                return "";
        }
    }

    @Step("Получить placeholder суммы оплаты для типа: {serviceType}")
    public String getSumInputPlaceholder(String serviceType) {
        switch (serviceType) {
            case "connection":
                return connectionSumInput.getAttribute("placeholder");
            case "internet":
                return internetSumInput.getAttribute("placeholder");
            case "instalment":
                return instalmentSumInput.getAttribute("placeholder");
            case "arrears":
                return arrearsSumInput.getAttribute("placeholder");
            default:
                return "";
        }
    }

    @Step("Получить placeholder e-mail для типа: {serviceType}")
    public String getEmailInputPlaceholder(String serviceType) {
        switch (serviceType) {
            case "internet":
                return internetEmailInput.getAttribute("placeholder");
            case "instalment":
                return instalmentEmailInput.getAttribute("placeholder");
            case "arrears":
                return arrearsEmailInput.getAttribute("placeholder");
            default:
                return "";
        }
    }

    @Step("Отправить форму")
    public PaymentFrame submitForm() {
        buttonContinue.click();
        PaymentFrame frame = new PaymentFrame(driver);
        frame.switchToPaymentFrame();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app-wrapper__content")));
        return frame;
    }
}
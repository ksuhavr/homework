import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentBlock extends BasePage {
    @FindBy(css = "div.pay__wrapper > h2")
    private WebElement titleElement;

    @FindBy(css = "img[alt='Visa']")
    private WebElement visaLogo;

    @FindBy(css = "img[alt='MasterCard']")
    private WebElement mastercardLogo;

    @FindBy(css = "img[alt='Белкарт']")
    private WebElement belkartLogo;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement linkLearnMore;

    public PaymentBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок блока оплаты")
    public String getTitle() {
        return titleElement.getText().replace("\n", " ").trim();
    }

    @Step("Проверить отображения логотипа Visa")
    public boolean isVisaLogoDisplayed() {
        return visaLogo.isDisplayed();
    }

    @Step("Проверить отображения логотипа Mastercard")
    public boolean isMastercardLogoDisplayed() {
        return mastercardLogo.isDisplayed();
    }

    @Step("Проверить отображения логотипа Белкарт")
    public boolean isBelkartLogoDisplayed() {
        return belkartLogo.isDisplayed();
    }

    @Step("Нажать на ссылку 'Подробнее о сервисе'")
    public void clickLinkLearnMore() {
        linkLearnMore.click();
    }
}
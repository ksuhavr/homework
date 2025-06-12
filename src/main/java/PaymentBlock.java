import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public String getTitle() {
        return titleElement.getText().replace("\n", " ").trim();
    }

    public boolean isVisaLogoDisplayed() {
        return visaLogo.isDisplayed();
    }

    public boolean isMastercardLogoDisplayed() {
        return mastercardLogo.isDisplayed();
    }

    public boolean isBelkartLogoDisplayed() {
        return belkartLogo.isDisplayed();
    }

    public void clickLinkLearnMore() {
        linkLearnMore.click();
    }
}
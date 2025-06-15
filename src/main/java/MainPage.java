import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(id = "cookie-agree")
    private WebElement cookieAgreeButton;

    private final PaymentBlock paymentBlock;
    private final PayFormBlock payFormBlock;

    public MainPage(WebDriver driver) {
        super(driver);
        this.paymentBlock = new PaymentBlock(driver);
        this.payFormBlock = new PayFormBlock(driver);
    }

    @Step("Принять Cookies")
    public void acceptCookies() {
        try {
            cookieAgreeButton.click();
        } catch (Exception ignored) {
        }
    }

    @Step("Получить блок оплаты")
    public PaymentBlock getPaymentBlock() {
        return paymentBlock;
    }

    @Step("Получить блок формы оплаты")
    public PayFormBlock getPayFormBlock() {
        return payFormBlock;
    }
}
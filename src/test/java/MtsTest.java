import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.*;

@Epic("Оплата услуг")
@Feature("Блок онлайн платежей")
public class MtsTest extends TestBase {

    @Test
    @Story("Заголовок блока")
    @Description("Проверка текста заголовка 'Онлайн пополнение без комиссии'")
    public void testOnlinePaymentBlockTitle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

        assertEquals("Онлайн пополнение без комиссии",
                mainPage.getPaymentBlock().getTitle());
    }

    @Test
    @Story("Логотипы платежных систем")
    @Description("Проверка отображения логотипов: Visa, Mastercard, Белкарт")
    public void testLogosOfPaymentSystems() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

        PaymentBlock paymentBlock = mainPage.getPaymentBlock();
        assertTrue(paymentBlock.isVisaLogoDisplayed(), "Логотип Visa не отображается");
        assertTrue(paymentBlock.isMastercardLogoDisplayed(), "Логотип Mastercard не отображается");
        assertTrue(paymentBlock.isBelkartLogoDisplayed(), "Логотип Белкарт не отображается");
    }

    @Test
    @Story("Ссылка 'Подробнее о сервисе'")
    @Description("Проверка перехода по ссылке 'Подробнее о сервисе'")
    public void testLinkLearnMoreAboutService() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

        mainPage.getPaymentBlock().clickLinkLearnMore();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(
                        "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    @Story("Кнопка 'Продолжить'")
    @Description("Проверка появления iframe после отправки формы оплаты")
    public void testContinueButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

        PaymentFrame paymentFrame = mainPage.getPayFormBlock()
                .fillForm("297777777", "10")
                .submitForm();

        assertTrue(paymentFrame.isFormDisplayed());
        paymentFrame.switchToDefaultContent();
    }

    @Test
    @Story("Плейсхолдеры для всех типов услуг")
    @Description("Проверка текста плейсхолдеров для услуг: связь, домашний интернет, рассрочка, задолженность")
    public void testFieldPlaceholdersForEachServiceType() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();
        PayFormBlock form = mainPage.getPayFormBlock();

        //"Услуги связи" (по умолчанию)
        assertEquals("Номер телефона", form.getPhoneInputPlaceholder("connection"));
        assertEquals("Сумма", form.getSumInputPlaceholder("connection"));

        //"Домашний интернет"
        form.selectServiceType("Домашний интернет");
        assertEquals("Номер абонента", form.getPhoneInputPlaceholder("internet"));
        assertEquals("Сумма", form.getSumInputPlaceholder("internet"));
        assertEquals("E-mail для отправки чека", form.getEmailInputPlaceholder("internet"));

        //"Рассрочка"
        form.selectServiceType("Рассрочка");
        assertEquals("Номер счета на 44", form.getPhoneInputPlaceholder("instalment"));
        assertEquals("Сумма", form.getSumInputPlaceholder("instalment"));
        assertEquals("E-mail для отправки чека", form.getEmailInputPlaceholder("instalment"));

        //"Задолженность"
        form.selectServiceType("Задолженность");
        assertEquals("Номер счета на 2073", form.getPhoneInputPlaceholder("arrears"));
        assertEquals("Сумма", form.getSumInputPlaceholder("arrears"));
        assertEquals("E-mail для отправки чека", form.getEmailInputPlaceholder("arrears"));
    }

    @Test
    @Story("Контент iframe оплаты")
    @Description("Проверка содержимого iframe: сумма, номер, подписи, логотипы")
    public void testPaymentFrameContent() {
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();

        PaymentFrame frame = mainPage.getPayFormBlock()
                .fillForm("297777777", "10")
                .submitForm();

        assertTrue(frame.isFormDisplayed(), "Форма не отобразилась");

        assertTrue(frame.getPayCost().contains("10"), "Сумма не отображается корректно");

        assertTrue(frame.getPayText().contains("297777777"), "Номер не отображается в описании");

        assertEquals("Номер карты", frame.getCardNumberLabel());
        assertEquals("Срок действия", frame.getCardValidityLabel());
        assertEquals("CVC", frame.getCvcLabel());
        assertEquals("Имя и фамилия на карте", frame.getCardNameLabel());

        assertTrue(frame.isPaymentIconsDisplayed(), "Отображаются не все логотипы платёжных систем");

        frame.switchToDefaultContent();
    }
}
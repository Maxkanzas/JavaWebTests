package tests.web;

import core.base.web.WebTestBase;
import core.pages.web.LoginPageWeb;
import core.pages.web.PageQRCodeWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginQRCodeTests extends WebTestBase {
    private LoginPageWeb loginPage;
    private PageQRCodeWeb pageQRCode;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPageWeb();
        pageQRCode = new PageQRCodeWeb();
    }
    @Test
    public void loginQrCodeTest() {
        step("Переходим на страницу с QR кодом", ()->{
            loginPage.loginByQrCode();
        });
        step("Проверяем наличие QR-кода на странице", ()->{
            assertTrue(pageQRCode.qrCodeIsPresent(), "QR код не отображается");
        });
    }
}

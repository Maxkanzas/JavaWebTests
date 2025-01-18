package tests;

import core.base.TestBase;
import core.pages.LoginPage;
import core.pages.PageQRCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginQRCode extends TestBase {
    private LoginPage loginPage;
    private PageQRCode pageQRCode;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        pageQRCode = new PageQRCode();
    }
    @Test
    public void loginNotPasswordTest() {
        step("Переходим на страницу с QR кодом", ()->{
            loginPage.loginByQrCode();
        });
        step("Проверяем наличие QR-кода на странице", ()->{
            assertTrue(pageQRCode.qrCodeIsPresent(), "QR код не отображается");
        });
    }
}

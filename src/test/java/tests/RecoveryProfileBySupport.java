package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryAccessPageByEmail;
import core.pages.RecoveryAccessPageBySupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RecoveryProfileBySupport extends BaseTest {
    private LoginPage loginPage;
    private RecoveryAccessPageBySupport recoveryAccessPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }
    @Test
    public void RecoveryProfileBySupportTest() {
        // Вход с неправильными данными
        loginPage.login("maxkanz1991", "1234567890");

        for (int i = 0; i < 2; i++) {
            loginPage.loginNotUserName("1");
        }
        loginPage.clickRestoreProfileButton();
        recoveryAccessPage = new RecoveryAccessPageBySupport();
        recoveryAccessPage.clickContactSupportButton();
        sleep(3000);
    }
}

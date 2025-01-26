package tests.web;

import core.base.web.WebTestBase;
import core.pages.web.LoginPageWeb;
import core.pages.web.RecoveryAccessPageByEmailWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryProfileByEmailTests extends WebTestBase {
    private LoginPageWeb loginPage;
    private RecoveryAccessPageByEmailWeb recoveryAccessPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPageWeb();
    }
    @Test
    public void RecoveryProfileByEmailTest() {
        // Вход с неправильными данными
        loginPage.login("maxkanz1991", "1234567890");

        for (int i = 0; i < 2; i++) {
            loginPage.loginNotUserName("1");
        }
        loginPage.clickRestoreProfileButton();
        recoveryAccessPage = new RecoveryAccessPageByEmailWeb();
        recoveryAccessPage.clickRecoverAccessByEmailButton();
    }
}

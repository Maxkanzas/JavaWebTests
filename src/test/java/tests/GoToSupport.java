package tests;

import core.base.TestBase;
import core.pages.HiddenElementsPage;
import core.pages.LoginPage;
import core.pages.RecoveryAccessPageBySupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class GoToSupport extends TestBase {
    private LoginPage loginPage;
    private RecoveryAccessPageBySupport recoveryAccessPage;
    private HiddenElementsPage hiddenElementsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        recoveryAccessPage = new RecoveryAccessPageBySupport();
        hiddenElementsPage = new HiddenElementsPage();
    }
    @Test
    public void GoToSupportTest() {
        step("Переходим на страницу с технической поддержкой", ()->{
            loginPage.clickSupport();
        });
        step("Нажимаем на кнопку Обратиться в службу поддержки", ()->{
            recoveryAccessPage.clickContactSupportButton();
        });
        step("Проверяем видимость окна с обращением", ()->{
            hiddenElementsPage.appealWindowIsPresent();
        });
        step("Закрываем окно с чатом", ()->{
            hiddenElementsPage.closeChat();
        });
        step("Нажимаем на кнопку ДА", ()->{
            hiddenElementsPage.confirmClose();
        });
    }
}

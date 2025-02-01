package tests.web;

import core.base.web.WebTestBase;
import core.pages.web.SupportPageWeb;
import core.pages.web.LoginPageWeb;
import core.pages.web.RecoveryAccessPageBySupportWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class GoToSupportTests extends WebTestBase {
    private LoginPageWeb loginPage;
    private RecoveryAccessPageBySupportWeb recoveryAccessPage;
    private SupportPageWeb hiddenElementsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPageWeb();
        recoveryAccessPage = new RecoveryAccessPageBySupportWeb();
        hiddenElementsPage = new SupportPageWeb();
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

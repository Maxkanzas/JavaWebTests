package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MobGoToSupportTests extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;
    private MobRecoveryPage mobRecoveryPage;
    private MobRecoveryAccessPage mobRecoveryAccessPage;
    private MobSupportPage mobSupportPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobStartPage = new MobStartPage();
        mobLoginPage = new MobLoginPage();
        mobRecoveryPage = new MobRecoveryPage();
        mobRecoveryAccessPage = new MobRecoveryAccessPage();
        mobSupportPage = new MobSupportPage();
    }
    @Test
    public void GoToSupportTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage.clickLoginButton();
        });
        step("Авторизация с некорректными данными", () -> {
            for (int i = 0; i < 3; i++) {
                mobLoginPage.login("IncorrectUserName", "IncorrectPassword");
            }
        });
        step("Переходим на общую страницу восстановления доступа", () -> {
            mobRecoveryPage.clickRecoverButton();
        });
        step("Переходим на страницу службы поддержки", () -> {
            mobRecoveryAccessPage.clickToSupportButton();
        });
        step("Проверяем видимость окна с обращением", ()->{
            mobSupportPage.chatWindowIsPresent();
        });
        step("Закрываем окно с чатом", ()->{
            mobSupportPage.closeChat();
        });
        step("Нажимаем на кнопку ДА", ()->{
            mobSupportPage.confirmClose();
        });
    }
}

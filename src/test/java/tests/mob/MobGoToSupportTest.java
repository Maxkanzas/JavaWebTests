package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MobGoToSupportTest extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;
    private MobRecoveryPage mobRecoveryPage;
    private MobRecoveryAccessPage mobRecoveryAccessPage;
    private MobSupportPage mobSupportPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }
    @Test
    public void GoToSupportTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage = new MobStartPage();
            mobStartPage.clickLoginButton();
        });
        step("Авторизация с некорректными данными", () -> {
            for (int i = 0; i < 3; i++) {
                mobLoginPage = new MobLoginPage();
                mobLoginPage.login("IncorrectUserName", "IncorrectPassword");
            }
        });
        step("Переходим на общую страницу восстановления доступа", () -> {
            mobRecoveryPage = new MobRecoveryPage();
            mobRecoveryPage.clickRecoverButton();
        });
        step("Переходим на страницу службы поддержки", () -> {
            mobRecoveryAccessPage = new MobRecoveryAccessPage();
            mobRecoveryAccessPage.clickToSupportButton();
        });
        step("Проверяем видимость окна с обращением", ()->{
            mobSupportPage = new MobSupportPage();
            mobSupportPage.checkMessageSupport();
        });
        step("Закрываем окно с чатом", ()->{
            mobSupportPage.closeChat();
        });
        step("Нажимаем на кнопку ДА", ()->{
            mobSupportPage.confirmClose();
        });
    }
}

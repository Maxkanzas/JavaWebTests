package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryProfileByEmailMobTests extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;
    private MobRecoveryPage mobRecoveryPage;
    private MobRecoveryAccessPage mobRecoveryAccessPage;
    private MobRecoveryAccessPageByEmail mobRecoveryAccessPageByEmail;
    private MobConfirmEmailPage mobConfirmEmailPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }
    @Test
    public void RecoveryProfileByEmailTest() {
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
        step("Переходим на страницу восстановления доступа по E-mail", () -> {
            mobRecoveryAccessPage = new MobRecoveryAccessPage();
            mobRecoveryAccessPage.clickRecoverAccessByEmailButton();
        });
        step("Вводим e-mail и получаем код для восстановления на почту", () -> {
            mobRecoveryAccessPageByEmail = new MobRecoveryAccessPageByEmail();
            mobRecoveryAccessPageByEmail.setEmail("email@email.com");
            mobRecoveryAccessPageByEmail.clickGetCode();
        });
        step("Проверяем наличие email, на который отправлен код восстановления", ()->{
            mobConfirmEmailPage = new MobConfirmEmailPage();
            mobConfirmEmailPage.emailConfirm();
        });
    }
    @Test
    public void RecoveryProfileNotEmailTest() {
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
        step("Переходим на страницу восстановления доступа по E-mail", () -> {
            mobRecoveryAccessPage = new MobRecoveryAccessPage();
            mobRecoveryAccessPage.clickRecoverAccessByEmailButton();
        });
        step("Проверка видимости ошибки ввода и текста ошибки", () -> {
            mobRecoveryAccessPageByEmail = new MobRecoveryAccessPageByEmail();
            mobRecoveryAccessPageByEmail.clickGetCode();
            assertTrue(mobRecoveryAccessPageByEmail.errorMessageVisible(), "Сообщение об ошибке не отображается");
            String expectedErrorMessage = "Неправильный формат почты";
            String actualErrorMessage = mobRecoveryAccessPageByEmail.getErrorMessageText();
            assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        });
    }
}

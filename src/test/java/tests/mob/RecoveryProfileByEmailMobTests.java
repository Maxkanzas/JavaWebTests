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
    private MobRecoveryAccessPageByPhone mobRecoveryAccessPageByPhone;
    private MobRecoveryAccessPageByEmail mobRecoveryAccessPageByEmail;
    private MobConfirmEmailPage mobConfirmEmailPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobStartPage = new MobStartPage();
        mobLoginPage = new MobLoginPage();
        mobRecoveryPage = new MobRecoveryPage();
        mobRecoveryAccessPage = new MobRecoveryAccessPage();
        mobRecoveryAccessPageByPhone = new MobRecoveryAccessPageByPhone();
        mobRecoveryAccessPageByEmail = new MobRecoveryAccessPageByEmail();
        mobConfirmEmailPage = new MobConfirmEmailPage();
    }
    @Test
    public void RecoveryProfileByEmailTest() {
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
        step("Переходим на страницу восстановления доступа по E-mail", () -> {
            mobRecoveryAccessPage.clickRecoverAccessByEmailButton();
        });
        step("Вводим e-mail и получаем код для восстановления на почту", () -> {
            mobRecoveryAccessPageByEmail.setEmail("email@email.com");
            mobRecoveryAccessPageByEmail.clickGetCode();
        });
        step("Проверяем наличие email, на который отправлен код восстановления", ()->{
            mobConfirmEmailPage.emailConfirm();
        });
    }
    @Test
    public void RecoveryProfileNotEmailTest() {
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
        step("Переходим на страницу восстановления доступа по E-mail", () -> {
            mobRecoveryAccessPage.clickRecoverAccessByEmailButton();
        });
        step("Проверка видимости ошибки ввода и текста ошибки", () -> {
            mobRecoveryAccessPageByEmail.clickGetCode();
            assertTrue(mobRecoveryAccessPageByEmail.errorMessageVisible(), "Сообщение об ошибке не отображается");
            String expectedErrorMessage = "Неправильный формат почты";
            String actualErrorMessage = mobRecoveryAccessPageByEmail.getErrorMessageText();
            assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        });
    }
}

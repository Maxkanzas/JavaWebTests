package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryProfileByPhoneNumberMobTest extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;
    private MobRecoveryPage mobRecoveryPage;
    private MobRecoveryAccessPage mobRecoveryAccessPage;
    private MobRecoveryAccessPageByPhone mobRecoveryAccessPageByPhone;
    private MobConfirmPhoneNumberPage mobConfirmPhoneNumberPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }
    @Test
    public void RecoveryProfileByPhoneNumberTest() {
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
        step("Переходим на страницу восстановления доступа по номеру телефона", () -> {
            mobRecoveryAccessPage = new MobRecoveryAccessPage();
            mobRecoveryAccessPage.clickRecoveryAccessByPhoneButton();
        });
        step("Выбираем страну, вводим номер телефона и получаем код для восстановления", () -> {
            mobRecoveryAccessPageByPhone = new MobRecoveryAccessPageByPhone();
            String countryCode = mobRecoveryAccessPageByPhone.dropDownSelectCountry("Россия");
            assertEquals("+7", countryCode, "Код страны не совпадаем с ожидаемым");
            mobRecoveryAccessPageByPhone.setPhoneNumber("9649910771");
            mobRecoveryAccessPageByPhone.clickGetCode();
        });
        step("Проверяем правильность ввода номера", () -> {
            mobConfirmPhoneNumberPage = new MobConfirmPhoneNumberPage();
            mobConfirmPhoneNumberPage.isPhoneNumberCorrect("7 (964) 991-07-71");
        });
    }
    @Test
    public void RecoveryProfileNotPhoneNumberTest() {
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
        step("Переходим на страницу восстановления доступа по номеру телефона", () -> {
            mobRecoveryAccessPage = new MobRecoveryAccessPage();
            mobRecoveryAccessPage.clickRecoveryAccessByPhoneButton();
        });
        step("Выбираем страну, вводим номер телефона и получаем код для восстановления", () -> {
            mobRecoveryAccessPageByPhone = new MobRecoveryAccessPageByPhone();
            mobRecoveryAccessPageByPhone.clickGetCode();
            assertTrue(mobRecoveryAccessPageByPhone.errorMessageVisible(), "Сообщение об ошибке не отображается");
            String expectedErrorMessage = "Введен неверный номер телефона";
            String actualErrorMessage = mobRecoveryAccessPageByPhone.getErrorMessageText();
            assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        });
    }
}

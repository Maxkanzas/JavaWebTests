package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryProfileByPhoneNumberMobTests extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;
    private MobRecoveryPage mobRecoveryPage;
    private MobRecoveryAccessPage mobRecoveryAccessPage;
    private MobRecoveryAccessPageByPhone mobRecoveryAccessPageByPhone;
    private MobConfirmPhoneNumberPage mobConfirmPhoneNumberPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobStartPage = new MobStartPage();
        mobLoginPage = new MobLoginPage();
        mobRecoveryPage = new MobRecoveryPage();
        mobRecoveryAccessPage = new MobRecoveryAccessPage();
        mobRecoveryAccessPageByPhone = new MobRecoveryAccessPageByPhone();
        mobConfirmPhoneNumberPage = new MobConfirmPhoneNumberPage();
    }
    @Test
    public void RecoveryProfileByPhoneNumberTest() {
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
        step("Переходим на страницу восстановления доступа по номеру телефона", () -> {
            mobRecoveryAccessPage.clickRecoveryAccessByPhoneButton();
        });
        step("Выбираем страну, вводим номер телефона и получаем код для восстановления", () -> {
            String countryCode = mobRecoveryAccessPageByPhone.dropDownSelectCountry("Россия");
            assertEquals("+7", countryCode, "Код страны не совпадаем с ожидаемым");
            mobRecoveryAccessPageByPhone.setPhoneNumber("9649910771");
            mobRecoveryAccessPageByPhone.clickGetCode();
        });
        step("Проверяем правильность ввода номера", () -> {
            mobConfirmPhoneNumberPage.isPhoneNumberCorrect("7 (964) 991-07-71");
        });
    }
    @Test
    public void RecoveryProfileNotPhoneNumberTest() {
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
        step("Переходим на страницу восстановления доступа по номеру телефона", () -> {
            mobRecoveryAccessPage.clickRecoveryAccessByPhoneButton();
        });
        step("Выбираем страну, вводим номер телефона и получаем код для восстановления", () -> {
            mobRecoveryAccessPageByPhone.clickGetCode();
            assertTrue(mobRecoveryAccessPageByPhone.errorMessageVisible(), "Сообщение об ошибке не отображается");
            String expectedErrorMessage = "Введен неверный номер телефона";
            String actualErrorMessage = mobRecoveryAccessPageByPhone.getErrorMessageText();
            assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
        });
    }
}

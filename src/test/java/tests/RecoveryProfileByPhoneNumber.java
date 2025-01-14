package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryAccessPageByPhone;
import core.pages.RecoveryAccessPageByPhoneDropDown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryProfileByPhoneNumber extends BaseTest {
    private LoginPage loginPage;
    private RecoveryAccessPageByPhone recoveryAccessPage;
    private RecoveryAccessPageByPhoneDropDown recoveryAccessPageDropDown;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }
    @Test
    public void RecoveryProfileByPhoneNumberTest() {
        // Вход с неправильными данными
        loginPage.login("maxkanz1991", "1234567890");

        for (int i = 0; i < 2; i++) {
            loginPage.loginNotUserName("1");
        }
        loginPage.clickRestoreProfileButton();
        recoveryAccessPage = new RecoveryAccessPageByPhone();
        recoveryAccessPage.clickRecoverAccessByPhoneButton();
        recoveryAccessPageDropDown = new RecoveryAccessPageByPhoneDropDown();
        String countryCode = recoveryAccessPageDropDown.dropDownSelectCountry("Россия");
        assertEquals("+7", countryCode, "Код страны не совпадаем с ожидаемым");
        recoveryAccessPageDropDown.clickGetCode();
        assertTrue(recoveryAccessPageDropDown.errorMessageVisible(), "Сообщение об ошибке не отображается");
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = recoveryAccessPageDropDown.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}

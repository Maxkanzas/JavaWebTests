package tests.web;

import core.base.web.WebTestBase;
import core.pages.web.LoginPageWeb;
import core.pages.web.RecoveryAccessPageByPhoneWeb;
import core.pages.web.RecoveryAccessPageByPhoneDropDownWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryProfileByPhoneNumberTests extends WebTestBase {
    private LoginPageWeb loginPage;
    private RecoveryAccessPageByPhoneWeb recoveryAccessPage;
    private RecoveryAccessPageByPhoneDropDownWeb recoveryAccessPageDropDown;
    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPageWeb();
    }
    @Tag("regress")
    @Test
    public void RecoveryProfileByPhoneNumberTest() {
        // Вход с неправильными данными
        loginPage.login("maxkanz1991", "1234567890");

        for (int i = 0; i < 2; i++) {
            loginPage.loginNotUserName("1");
        }
        loginPage.clickRestoreProfileButton();
        recoveryAccessPage = new RecoveryAccessPageByPhoneWeb();
        recoveryAccessPage.clickRecoverAccessByPhoneButton();
        recoveryAccessPageDropDown = new RecoveryAccessPageByPhoneDropDownWeb();
        String countryCode = recoveryAccessPageDropDown.dropDownSelectCountry("Россия");
        assertEquals("+7", countryCode, "Код страны не совпадаем с ожидаемым");
        recoveryAccessPageDropDown.clickGetCode();
        assertTrue(recoveryAccessPageDropDown.errorMessageVisible(), "Сообщение об ошибке не отображается");
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = recoveryAccessPageDropDown.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}

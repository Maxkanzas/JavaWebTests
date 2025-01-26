
package tests.web;

import core.base.web.WebTestBase;
import core.pages.web.LoginPageWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNotPasswordTests extends WebTestBase {
    private LoginPageWeb loginPageWeb;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPageWeb = new LoginPageWeb();
    }

    @Test
    public void loginNotPasswordTest() {
        // Вход с неправильными данными
        loginPageWeb.login("Филип Филипыч", "");
        // Проверка наличия текста сообщения об ошибке
        assertTrue(loginPageWeb.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPageWeb.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
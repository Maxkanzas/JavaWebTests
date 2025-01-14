package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNotUserName extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void loginNotUserNameTest() {
        // Вход с неправильными данными
        loginPage.login("", "Qjknhkladb231!@");
        // Проверка наличия текста сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}

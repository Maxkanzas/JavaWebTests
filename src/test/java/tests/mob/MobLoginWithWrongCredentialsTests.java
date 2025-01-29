package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobStartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobLoginWithWrongCredentialsTests extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }

    @Test
    public void loginWithWrongCredentialsTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage = new MobStartPage();
            mobStartPage.clickLoginButton();
        });
        step("Авторизация с некорректными данными", () -> {
            mobLoginPage = new MobLoginPage();
            mobLoginPage.login("IncorrectUserName", "IncorrectPassword");
        });
        step("Проверка появления сообщения об ошибке", () -> {
            assertTrue(mobLoginPage.isErrorMessageVisible(), "Сообщение об ошибке не отображается");
        });
        step("Проверка текста сообщения об ошибке", () -> {
            String expectedTextMessage = "Неверный логин или пароль";
            String actualTextMessage = mobLoginPage.getErrorMessageText();
            assertEquals(expectedTextMessage, actualTextMessage, "Текст сообщения не совпадает");
        });
    }
}

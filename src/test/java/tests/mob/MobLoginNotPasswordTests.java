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

public class MobLoginNotPasswordTests extends MobTestBase {
    private MobStartPage mobStartPage;
    private MobLoginPage mobLoginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobStartPage = new MobStartPage();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void loginNotPasswordTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage.clickLoginButton();
        });
        step("Авторизация без ввода пароля", () -> {
            mobLoginPage.loginNotPassword("IncorrectUserName");
        });
        step("Проверка появления сообщения валидации под полем пароль", () -> {
            assertTrue(mobLoginPage.validationTextPasswordVisible(), "Сообщение о валидации не отображается");
        });
        step("Проверка текста сообщения валидации под полем пароль", () -> {
            String expectedTextMessage = "Укажите пароль";
            String actualTextMessage = mobLoginPage.getValidationPasswordText();
            assertEquals(expectedTextMessage, actualTextMessage, "Текст сообщения не совпадает");
        });
    }
}
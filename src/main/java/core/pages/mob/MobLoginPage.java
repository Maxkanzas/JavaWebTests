package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobLoginPage extends MobBasePage {
    private SelenideElement userNameField = $("#field_login");
    private SelenideElement passwordField = $("#field_password");
    private SelenideElement loginButton = $("[name='button_login']");
    private SelenideElement forgotLink = $("a.base-button_target[href*='newRecoveryStart']");
    private SelenideElement errorMessage = $("#ferr");
    private SelenideElement validationTextPassword = $(".field_error-descr[for='field_password']");
    private SelenideElement validationTextUserName = $(".field_error-descr[for='field_login']");

    @Step("Входим на сайт с логином и паролем")
    public void login(String userName, String password) {
        userNameField.setValue(userName);
        passwordField.setValue(password);
        loginButton.click();
    }
    @Step("Входим на сайт с логином без пароля")
    public void loginNotPassword(String userName) {
        userNameField.shouldBe(visible).setValue(userName);
        loginButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт с паролем без логина")
    public void loginNotUserName(String password) {
        passwordField.setValue(password);
        loginButton.click();
    }
    @Step("Нажимаем на кнопку не получается войти")
    public void clickSupport() {
        forgotLink.click();
    }
    @Step("Проверяем видимость сообщения ошибки ввода")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
    @Step("Проверяем видимость текста ошибки под полем пароль")
    public boolean validationTextPasswordVisible() {
        return validationTextPassword.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения ошибки под полем пароль")
    public String getValidationPasswordText() {
        return validationTextPassword.shouldBe(visible).getText();
    }
    @Step("Проверяем видимость текста ошибки под полем логин")
    public boolean validationTextLoginVisible() {
        return validationTextUserName.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения ошибки под полем логин")
    public String getValidationLoginText() {
        return validationTextUserName.shouldBe(visible).getText();
    }
}

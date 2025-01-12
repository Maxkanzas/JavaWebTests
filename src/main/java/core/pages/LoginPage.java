package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    private SelenideElement userNameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("input.button-pro.__wide[type='submit'][value='Войти в Одноклассники']");
    private SelenideElement enterQrCodeLink = $("[data-l='t,get_qr']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $(".external-oauth-login-footer a.button-pro.__sec.__wide");

    // Локаторы для кнопок социальных сетей
    private SelenideElement vkButton = $("[data-app-id='7525058']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");

    // Локатор для элемента сообщения об ошибке ввода
    private SelenideElement errorMessage = $(".js-form-error-message");

    // Локаторы для восстановления профиля
    private SelenideElement recoveryProfileButton = $("[value='st.go_to_recovery']");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        userNameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        enterQrCodeLink.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }
    @Step("Проверяем видимость сообщения ошибки ввода")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об оишбке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
    @Step("Входим на сайт с логином и паролем")
    public void login(String userName, String password) {
        userNameField.shouldBe(visible).setValue(userName);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт с логином без пароля")
    public void loginNotPassword(String userName) {
        userNameField.shouldBe(visible).setValue(userName);
        loginButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт без логина с паролем")
    public void loginNotUserName(String password) {
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку войти в ОК")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }
    @Step("Вводим пароль")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
    }
    @Step("Переход на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }
    @Step("Переход на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт через иконку VK")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт через иконку Mail.ru")
    public void mailRuButton(){
        mailRuButton.shouldBe(visible).click();
    }
    @Step("Входим на сайт через иконку Yandex")
    public void yandexButton(){
        yandexButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку восстановить профиль")
    public void clickRestoreProfileButton() {
        recoveryProfileButton.shouldBe(visible).click();
    }
}

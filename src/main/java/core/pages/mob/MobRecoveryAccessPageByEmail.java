package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobRecoveryAccessPageByEmail {
    private SelenideElement inputField = $("#field_email");
    private SelenideElement getCodeButton = $("#reg_email_button");
    private SelenideElement errorMessage = $(".field_error-descr[for='field_email']");

    @Step("Кликаем на кнопку получить код")
    public void clickGetCode() {
        getCodeButton.shouldBe(visible).click();
    }
    @Step("Вводим в поле ввода E-mail")
    public void setEmail(String email) {
        inputField.shouldBe(visible).setValue(email);
    }
    @Step("Проверяем видимость сообщения ошибки ввода")
    public boolean errorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}

package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobStartPage extends MobBasePage {
    private SelenideElement loginButton = $("[name='loginButton']");
    private SelenideElement regButton = $("[name='registerButton']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        loginButton.shouldBe(visible);
        regButton.shouldBe(visible);
    }

    @Step("Кликаем на кнопку Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Кликаем на кнопку Зарегистрироваться")
    public void clickRegButton() {
        regButton.click();
    }
}

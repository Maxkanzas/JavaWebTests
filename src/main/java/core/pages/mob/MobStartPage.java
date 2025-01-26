package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import core.base.mob.MobTestBase;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobStartPage extends MobBasePage {
    private SelenideElement loginButton = $("[name='loginButton']");
    private SelenideElement regButton = $("[name='registerButton']");
    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
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

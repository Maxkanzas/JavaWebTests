package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobConfirmEmailPage extends MobBasePage {
    private SelenideElement email = $(".registration_description_phone");

    @Step("Проверяем email, на который отправлен код восстановления")
    public void emailConfirm() {
        email.shouldBe(visible);
    }
}
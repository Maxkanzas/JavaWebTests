package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobConfirmPhoneNumberPage extends MobBasePage {
    private SelenideElement phoneNumberField = $(".registration_description_phone");

    @Step("Проверяем email, на который отправлен код восстановления")
    public boolean isPhoneNumberCorrect(String expectedPhoneNumber) {
        return phoneNumberField.shouldBe(visible).has(text(expectedPhoneNumber));
    }
}
package core.pages.mob;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobRecoveryAccessPage {
    private SelenideElement recoveryByPhoneButton = $(".registration_steps a[href*='newRecoveryStartPhoneLink']");
    private SelenideElement recoveryByEmailButton = $(".registration_steps a[href*='newRecoveryStartEmailLink']");
    private SelenideElement supportButton = $(".registration_footer a[href*='accountRecoverFeedbackForm']");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(Condition.visible);
        recoveryByEmailButton.shouldBe(Condition.visible);
        supportButton.shouldBe(Condition.visible);
    }
    @Step("Нажимаем на кнопку восстановления доступа по телефону")
    public void clickRecoveryAccessByPhoneButton() {
        recoveryByPhoneButton.click();
    }
    @Step("Нажимаем на кнопку восстановления доступа по E-mail")
    public void clickRecoverAccessByEmailButton() {
        recoveryByEmailButton.click();
    }
    @Step("Нажимаем на кнопку Служба поддержки")
    public void clickToSupportButton() {
        supportButton.click();
    }
}

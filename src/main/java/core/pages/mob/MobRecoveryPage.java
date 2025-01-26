package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobRecoveryPage {
    private SelenideElement closeButton = $("[name='return']");
    private SelenideElement recoveryButton = $("[name='restore']");

    @Step("Нажимаем на кнопку закрыть")
    public void closeRecovery() {
        closeButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку восстановить")
    public void clickRecoverButton() {
        recoveryButton.shouldBe(visible).click();
    }

}

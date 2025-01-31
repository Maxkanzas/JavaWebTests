package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobRecoveryPage extends MobBasePage {
    private SelenideElement closeButton = $("[name='return']");
    private SelenideElement recoveryButton = $("[name='restore']");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        closeButton.shouldBe(visible);
        recoveryButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку закрыть")
    public void closeRecovery() {
        closeButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку восстановить")
    public void clickRecoverButton() {
        recoveryButton.shouldBe(visible).click();
    }

}

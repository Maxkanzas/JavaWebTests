package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MobRecoveryAccessPage {
    private SelenideElement recoveryByPhoneButton = $("a.clickarea[data-log-click*='phone']");
    private SelenideElement recoveryByEmailButton = $("a.clickarea[data-log-click*='email']");
    private SelenideElement supportButton = $("a.registration_footer_link[data-log-click*='support']");
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

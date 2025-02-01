package core.pages.mob;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class MobRecoveryAccessPage extends MobBasePage {
    private SelenideElement recoveryByPhoneButton =
            $(By.xpath("//div[contains(@class, 'content-card') and .//div[text()='Телефон']]"));
    private SelenideElement recoveryByEmailButton =
            $(By.xpath("//div[contains(@class, 'content-card') and .//div[text()='Электронная почта']]"));
    private SelenideElement supportButton =
            $("a.registration_footer_link[data-log-click*='\"target\":\"support\"']");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        supportButton.shouldBe(visible);
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

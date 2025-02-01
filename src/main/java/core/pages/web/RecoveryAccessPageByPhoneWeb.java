package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryAccessPageByPhoneWeb extends WebBasePage {
    // Локаторы для кнопок восстановления пароля
    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    {
        verifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
    }
    @Step("Нажимаем на кнопку восстановления доступа по телефону")
    public void clickRecoverAccessByPhoneButton() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }
}

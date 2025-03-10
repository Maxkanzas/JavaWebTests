package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryAccessPageByEmailWeb extends WebBasePage {
    // Локаторы для кнопок восстановления пароля
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");

    {
        verifyPageElements();
    }
    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        recoveryByEmailButton.shouldBe(visible);
    }
    @Step("Нажимаем на кнопку восстановления доступа по E-mail")
    public void clickRecoverAccessByEmailButton() {
        recoveryByEmailButton.shouldBe(visible).click();
    }
}

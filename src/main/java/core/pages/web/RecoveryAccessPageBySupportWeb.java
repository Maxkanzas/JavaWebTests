package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryAccessPageBySupportWeb extends WebBasePage {
    // Локаторы для кнопки связи со службой поддержки
    private SelenideElement supportCustomerButton = $("[data-l='t,support']");

    @Step("Нажимаем на кнопку обратиться в службу поддержки")
    public void clickContactSupportButton() {
        supportCustomerButton.shouldBe(visible).click();
    }
}

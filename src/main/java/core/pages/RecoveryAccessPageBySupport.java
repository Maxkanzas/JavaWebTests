package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryAccessPageBySupport extends BasePage {
    // Локаторы для кнопки связи со службой поддержки
    private SelenideElement supportCustomerButton = $("[data-l='t,support']");

    @Step("Нажимаем на кнопку обратиться в службу поддержки")
    public void clickContactSupportButton() {
        supportCustomerButton.shouldBe(visible).click();
    }
}

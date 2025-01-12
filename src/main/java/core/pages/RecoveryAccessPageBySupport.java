package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryAccessPageBySupport extends BasePage {
    // Локаторы для кнопок восстановления пароля
    private SelenideElement supportCustomerButton = $(".support-link_item-text");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        supportCustomerButton.shouldBe(visible);
    }
    @Step("Нажимаем на кнопку обратиться в службу поддержки")
    public void clickContactSupportButton() {
        supportCustomerButton.shouldBe(visible).click();
    }
}

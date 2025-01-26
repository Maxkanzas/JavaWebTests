package core.base.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobBasePage {
    // Общие элементы, которые используются на разных страницах
    protected SelenideElement burgerMenu = $(".toolbar_actions-i_inner");
    protected SelenideElement okButton = $("#lgo");
    protected SelenideElement searchButton = $("a.base-button_target[href*='anonymUsersAllSearch']");

    @Step("Кликаем на бургер меню")
    public void clickBurgerMenu() {
        burgerMenu.shouldBe(visible).click();
    }
    @Step("Кликаем на значок OK")
    public void clickOkButton() {
        okButton.shouldBe(visible).click();
    }
    @Step("Кликаем на значок поиска")
    public void clickSearchButton() {
        searchButton.shouldBe(visible).click();
    }
}
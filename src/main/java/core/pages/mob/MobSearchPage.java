package core.pages.mob;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobSearchPage extends MobBasePage {
    private SelenideElement searchField = $("#AnonymGlobalAllSearchFormField");
    private SelenideElement dropDownMenu = $("#search-all_items");
    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        searchField.shouldBe(visible);
    }
    @Step("Вводим поле поиска тестировщик")
    public void inputFieldText(String value) {
        searchField.click();
        searchField.setValue(value);
    }
    @Step("Ожидание появления выпадающего меню с результатами")
    public void setDropDownMenuVisible() {
        dropDownMenu.shouldBe(Condition.visible).shouldHave(Condition.text("Тестировщик")).click();
    }
}

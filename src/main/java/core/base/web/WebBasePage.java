package core.base.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class WebBasePage {
    // Общие элементы, которые используются на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar-search-input']");
    protected SelenideElement inputSearchField = $(".input__prt1l");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    // Локатор для drop down меню
    private SelenideElement dropDownMenu = $("[data-tsid='search-suggest-wrapper']");

    @Step("Кликаем на поисковую строку")
    public void clickInputSearchField() {
        inputSearchField.shouldBe(visible).click();
    }
    @Step("Выполянем поиск по сайту с запросом: {query}")
    public void setInputSearchField(String query) {
        inputSearchField.shouldBe(visible).setValue(query);
    }
    @Step("Ожидание появления выпадающего меню с результатами")
    public void setDropDownMenuVisible() {
        dropDownMenu.shouldBe(Condition.visible).shouldHave(Condition.text("Тестировщик"));
    }
    @Step("Выбираем вкладку {тестировщик} из выпадающего списка и переходим на страницу со списком групп")
    public void selectValue(String value) {
        dropDownMenu.$(Selectors.byText(value)).click();
    }
    @Step ("Открываем VK services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }
    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

```public class BasePage {
    // Общие элементы, которые используются на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar-search-input']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    // Локатор для drop-down меню
    private SelenideElement searchSelect = $(".dropdown-results__4nym2");

    @Step("Выполянем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query);
    }
    @Step ("Открываем VK services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }
    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
    @Step("Выбираем вкладку {value} из выпадающего списка")
    public String searchSelectValue(String value) {
        searchSelect.click();
        SelenideElement valueItem = $(".suggest-list__zd7xg");
        valueItem.scrollTo();
        String qaText = valueItem.find(".suggest-item__zd7xg").text();
        valueItem.click();
        return qaText;
    }
}```

// SelenideElement valueItem = $$(".suggest-list__zd7xg").get(3).$("a");
//SelenideElement valueItem = $(String.format(".suggest-list__zd7xg", value));
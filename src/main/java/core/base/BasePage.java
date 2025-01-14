package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class BasePage {
    // Общие элементы, которые используются на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar-search-input']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    @Step("Выполянем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
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

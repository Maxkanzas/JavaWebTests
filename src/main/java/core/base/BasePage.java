package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class BasePage {
    // Общие элементы, которые используются на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar-search-input']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    // Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }
    // Общий метод для клика по иконке
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }
    // Клик на логотип ОК
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}

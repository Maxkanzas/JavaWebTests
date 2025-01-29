package core.pages.mob;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobSearchPage extends MobStartPage {
    private SelenideElement searchField = $("[name='mfr.search']");
    private SelenideElement hobbyButton = $("a.data-log-click[href*='hobby']");
    private SelenideElement profileButton = $("a.data-log-click[href*='profiles']");
    private SelenideElement videoButton = $("a.data-log-click[href*='video']");
    private SelenideElement publicationButton = $("a.data-log-click[href*='content']");
    private SelenideElement groupsButton = $("a.data-log-click[href*='groups']");
    private SelenideElement dropDownMenu = $("#search-all_items");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        searchField.shouldBe(visible);
        hobbyButton.shouldBe(visible);
        profileButton.shouldBe(visible);
        videoButton.shouldBe(visible);
        publicationButton.shouldBe(visible);
        groupsButton.shouldBe(visible);
    }

    @Step("Кликаем на поле поиска")
    public void clickSearchField() {
        searchField.click();
    }
    @Step("Вводим поле поиска тестировщик")
    public void clickLoginButton(String value) {
        searchField.setValue(value);
    }
    @Step("Кликаем на кнопку Увлечения")
    public void clickLoginButton() {
        hobbyButton.click();
    }
    @Step("Кликаем на кнопку Люди")
    public void clickProfileButton() {
        profileButton.click();
    }
    @Step("Кликаем на кнопку Видео")
    public void clickVideoButton() {
        videoButton.click();
    }
    @Step("Кликаем на кнопку Публикации")
    public void clickPublicationButton() {
        publicationButton.click();
    }
    @Step("Кликаем на кнопку Группы")
    public void clickGroupsButton() {
        groupsButton.click();
    }
    @Step("Ожидание появления выпадающего меню с результатами")
    public void setDropDownMenuVisible() {
        dropDownMenu.shouldBe(Condition.visible).shouldHave(Condition.text("Тестировщик")).click();
    }
}

package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HiddenElementsPage extends BasePage {
    // Локатор для окна с поддержкой
    private SelenideElement appealWindow = $(".modal-new_close_ovr");
    // Локатор для закрытия чата "крестик"
    private SelenideElement chatCloseButton = $("[name='ico_close_16']");
    // Локатор для кнопки "Да", после закрытия чата
    private SelenideElement confirmCloseButton = $(".button__pe9qo");

    @Step("Проверяем наличие окна с обращением")
    public boolean appealWindowIsPresent() {
        return appealWindow.shouldBe(visible).exists();
    }
    @Step("Нажимаем на крестик у чата")
    public void closeChat() {
        chatCloseButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку Да")
    public void confirmClose() {
        confirmCloseButton.shouldBe(visible).click();
    }
}

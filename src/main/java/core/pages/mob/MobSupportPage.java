package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.mob.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobSupportPage extends MobBasePage {
    private SelenideElement chatWindow = $(".content-wrapper__n9ga2");
    // Локатор для закрытия чата "крестик"
    private SelenideElement chatCloseButton = $(".button-icon__tndfc");
    // Локатор для кнопки "Да", после закрытия чата
    private SelenideElement confirmCloseButton = $$(".item__1ejp4 button").get(0);

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        chatWindow.shouldBe(visible);
        chatCloseButton.shouldBe(visible);
    }

    @Step("Проверяем наличие окна с обращением")
    public boolean chatWindowIsPresent() {
        return chatWindow.shouldBe(visible).exists();
    }
    @Step("Нажимаем на крестик у чата")
    public void closeChat() {
        chatCloseButton.shouldBe(visible).click();
    }
    @Step("Нажимаем на кнопку Да")
    public void confirmClose() {
        confirmCloseButton.click();
    }
}
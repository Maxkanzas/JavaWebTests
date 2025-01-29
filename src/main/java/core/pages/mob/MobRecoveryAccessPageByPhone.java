package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MobRecoveryAccessPageByPhone {
    private SelenideElement inputField = $("#field_phone");
    private SelenideElement getCodeButton = $("#getCode");
    private SelenideElement countryButton = $("#countryName");
    private SelenideElement errorMessage = $(".field_error-descr[for='field_phone']");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        inputField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
        countryButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения ошибки ввода")
    public boolean errorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
    @Step("Кликаем на кнопку получить код")
    public void clickGetCode() {
        getCodeButton.shouldBe(visible).click();
    }
    @Step("Выбираем страну из выпадающего списка")
    public String dropDownSelectCountry(String country) {
        countryButton.click();
        SelenideElement countryItem = $x("//a[contains(@data-model, '\"name\":\"" + country + "\"')]").scrollTo();
        executeJavaScript("arguments[0].click();", countryItem);
        String countryCode = countryItem.getAttribute("data-model").replaceAll(".*prefix\":\"|\".*", "");
        return countryCode;
    }
    @Step("Вводим номер телефона в поле ввода")
    public void setPhoneNumber(String number) {
        inputField.shouldBe(visible).setValue(number);
    }
}

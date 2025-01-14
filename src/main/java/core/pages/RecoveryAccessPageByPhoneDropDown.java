package core.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class RecoveryAccessPageByPhoneDropDown extends BasePage {
    // Локатор для ввода номера телефона
    private SelenideElement recoveryPhoneInput = $("[name='st.r.phone']");
    // Локатор для drop-down меню
    private SelenideElement countrySelect = $(".js-country-input");
    // Локатор для кнопки получить код
    private SelenideElement getCode = $("[data-l='t,submit']");
    // Локатор для сообщения об ошибке
    private SelenideElement errorMessageIncorrectNumber = $("div.input-e.js-ph-vl-hint");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        countrySelect.shouldBe(visible);
        recoveryPhoneInput.shouldBe(visible);
        getCode.shouldBe(visible);
    }
    @Step("Проверяем видимость сообщения ошибки ввода")
    public boolean errorMessageVisible() {
        return errorMessageIncorrectNumber.shouldBe(visible).exists();
    }
    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessageIncorrectNumber.shouldBe(visible).getText();
    }
    @Step
    public void clickGetCode() {
        getCode.shouldBe(visible).click();
    }
    @Step("Выбираем страну из выпадающего списка")
    public String dropDownSelectCountry(String country) {
        countrySelect.click();
        SelenideElement countryItem = $(".country-select_i[data-name='" + country + "']");
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }
}

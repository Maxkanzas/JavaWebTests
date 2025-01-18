package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PageQRCode extends BasePage {
    // Локаторы для QR кода
    private SelenideElement qrCode = $("[class='qr_code_image_wrapper']");
    @Step("Проверяем наличие qr код")
    public boolean qrCodeIsPresent() {
        return qrCode.shouldBe(visible).exists();
    }
}

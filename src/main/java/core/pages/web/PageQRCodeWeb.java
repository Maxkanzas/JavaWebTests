package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.web.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PageQRCodeWeb extends WebBasePage {
    // Локаторы для QR кода
    private SelenideElement qrCode = $(".qr_code_image_wrapper > img[src*='qrcode']");
    @Step("Проверяем наличие qr код")
    public boolean qrCodeIsPresent() {
        return qrCode.shouldBe(visible).exists();
    }
}

package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobTesterPage {
    protected SelenideElement listGroups = $("#searchableListContent");

    {
        verifyPageElements();
    }
    @Step ("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        listGroups.shouldBe(visible);
    }

    @Step("Проверяем, что список групп открылся")
    public void checkListGroupsSuccess() {
        listGroups.shouldBe(visible);
    }
}

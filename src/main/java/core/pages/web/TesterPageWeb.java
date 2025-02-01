package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TesterPageWeb {
    protected SelenideElement listGroups = $("#hook_Block_UserGroupsSearchPortal");

    @Step("Проверяем, что список групп открылся")
    public void setListGroupsSuccess() {
        listGroups.shouldBe(visible);
    }
}
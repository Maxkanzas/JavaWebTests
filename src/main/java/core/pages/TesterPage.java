package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TesterPage {
    protected SelenideElement listGroups = $("#hook_Block_UserGroupsSearchPortal");

    @Step("Проверяем, что список групп открылся")
    public void setListGroupsSuccess() {
        listGroups.shouldBe(visible);
    }
}
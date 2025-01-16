package tests;

import com.codeborne.selenide.Condition;
import core.base.BasePage;
import core.base.TestBase;
import core.pages.TesterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class SearchGroups extends TestBase {
    private BasePage basePage;
    private TesterPage testerPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        basePage = new BasePage();
        testerPage = new TesterPage();
    }
    @Test
    public void SearchGroupsTest() {
        step("В поисковой строке вводим тестировщик", ()->{
            basePage.setInputSearchField("Тестировщик");
        });
        step("Выбираем вкладку тестировщик и кликаем на нее", ()->{
            basePage.setDropDownMenuVisible();
            basePage.selectValue("Тестировщик");
        });
        step("Проверяем, что список групп отобразился на странице", ()->{
            testerPage.setListGroupsSuccess();
        });
    }
}

package tests.web;

import core.base.web.WebBasePage;
import core.base.web.WebTestBase;
import core.pages.web.TesterPageWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class SearchGroupsTests extends WebTestBase {
    private WebBasePage webBasePage;
    private TesterPageWeb testerPageWeb;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        webBasePage = new WebBasePage();
        testerPageWeb = new TesterPageWeb();
    }
    @Test
    public void SearchGroupsTest() {
        step("В поисковой строке вводим тестировщик", ()->{
            webBasePage.clickInputSearchField();
            webBasePage.setInputSearchField("Тестировщик");
        });
        step("Выбираем вкладку тестировщик и кликаем на нее", ()->{
            webBasePage.setDropDownMenuVisible();
            webBasePage.selectValue("Тестировщик");
        });
        step("Проверяем, что список групп отобразился на странице", ()->{
            testerPageWeb.setListGroupsSuccess();
        });
    }
}

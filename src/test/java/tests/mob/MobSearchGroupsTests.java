package tests.mob;

import core.base.mob.MobBasePage;
import core.base.mob.MobTestBase;
import core.pages.mob.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MobSearchGroupsTests extends MobTestBase {
    private MobBasePage mobBasePage;
    private MobStartPage mobStartPage;
    private MobSearchPage mobSearchPage;
    private MobTesterPage mobTesterPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobStartPage = new MobStartPage();
        mobBasePage = new MobBasePage();
        mobSearchPage = new MobSearchPage();
        mobTesterPage = new MobTesterPage();
    }
    @Test
    public void SearchGroupsTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage.clickLoginButton();
        });
        step("Кликнуть на лупу поиска", () -> {
            mobBasePage.clickSearchButton();
        });
        step("В поле поиска ввести слово тестировщик", () -> {
            mobSearchPage.clickSearchField();
            mobSearchPage.clickLoginButton("Тестировщик");
        });
        step("Выбираем вкладку тестировщик и кликаем на нее", () -> {
            mobSearchPage.setDropDownMenuVisible();
        });
        step("Проверяем открытый список поиска", () -> {
            mobTesterPage.checkListGroupsSuccess();
        });
    }
}

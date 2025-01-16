package tests;

import core.base.BasePage;
import core.base.TestBase;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

```public class SearchGroups extends TestBase {
    private BasePage basePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        basePage = new BasePage();
    }
    @Test
    public void SearchGroupsTest() {
        step("В поисковой строке вводим тестировщик", ()->{
            basePage.search("Тестировщик");
        });
        step("Выбираем вкладку тестировщик", ()->{
            basePage.searchSelectValue("Тестировщик");
        });
    }
}```

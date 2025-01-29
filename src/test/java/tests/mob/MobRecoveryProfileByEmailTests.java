package tests.mob;

import core.base.mob.MobTestBase;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobStartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MobRecoveryProfileByEmailTests extends MobTestBase {
    private MobLoginPage mobLoginPage;
    private MobStartPage mobStartPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
    }
    @Test
    public void RecoveryProfileByEmailTest() {
        step("Переходим на страницу авторизации", () -> {
            mobStartPage = new MobStartPage();
            mobStartPage.clickLoginButton();
        });
        step("Авторизация с некорректными данными", () -> {
            mobLoginPage = new MobLoginPage();
            mobLoginPage.login("IncorrectUserName", "IncorrectPassword");
            for (int i = 0; i < 2; i++) {
                mobLoginPage.loginNotUserName("IncorrectPassword");
            }
        });

    }
}

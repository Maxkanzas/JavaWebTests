package core.base.mob;

import com.codeborne.selenide.Configuration;
import core.base.AbstractBaseTest;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobTestBase extends AbstractBaseTest {
    @Override
    protected void configure(){
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));
        Configuration.browserCapabilities = options;
    }
}
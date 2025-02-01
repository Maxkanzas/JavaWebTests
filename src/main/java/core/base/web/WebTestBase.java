package core.base.web;

import com.codeborne.selenide.Configuration;
import core.base.AbstractBaseTest;

public class WebTestBase extends AbstractBaseTest {
    @Override
    protected void configure(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}
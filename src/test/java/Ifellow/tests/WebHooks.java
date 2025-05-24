package Ifellow.tests;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;

import static ifellow.Config.JIRA_URL;

@Getter
public abstract class WebHooks {
    private final String defaultLogin = "AT5";
    private final String defaultPassword = "Qwerty123";

    @BeforeEach
    public void testConfig() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open(JIRA_URL.get());
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTesting() {
        Selenide.closeWebDriver();
    }
}
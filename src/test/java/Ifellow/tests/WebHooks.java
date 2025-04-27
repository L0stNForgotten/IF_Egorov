package Ifellow.tests;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;

@Getter
public abstract class WebHooks {
    private final String defaultLogin = "AT5";
    private final String defaultPassword = "Qwerty123";

    @BeforeEach
    public void testConfig() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 5000;
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTesting() {
        Selenide.closeWebDriver();
    }
}
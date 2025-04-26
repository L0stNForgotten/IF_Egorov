package Ifellow.tests;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.*;
import org.openqa.selenium.*;
import lombok.*;

@Getter
public abstract class WebHooks {
    private final String defaultLogin = "AT5";
    private final String defaultPassword = "Qwerty123";

    @BeforeEach
    public void testConfig() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 10000;
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTesting() {
        Selenide.closeWebDriver();
    }
}
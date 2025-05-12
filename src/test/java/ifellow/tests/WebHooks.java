package ifellow.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;

public class WebHooks {
    @BeforeEach
    public void testConfig() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open("https://edujira.ifellow.ru/");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTesting() {
        Selenide.closeWebDriver();
    }
}
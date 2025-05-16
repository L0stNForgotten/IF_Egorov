package ifellow.cucumber.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;

public class Hook {
    @Before
    public void testConfig() {
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open("https://edujira.ifellow.ru/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After
    public void afterScenario() {
        Selenide.closeWebDriver();  // Закрывает браузер после каждого сценария
    }
}

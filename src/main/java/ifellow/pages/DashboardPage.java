package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement dashboardProjectTab = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']")
            .as("Дэшборд вкладка проекты");

    private final SelenideElement dashboardProjectIcon = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']")
            .as("Вкладка проектов");
    private final SelenideElement dashboardProjects = $x("//ul[@class='aui-nav']//div//a[@href='/browse/TEST']")
            .as("Проекты");

    public void dashboardIsOpen() {
        Assertions.assertTrue(dashboardProjectTab.shouldBe(visible, Duration.ofSeconds(15)).isDisplayed());
    }

    public void dashboardUse() {
        dashboardProjectIcon.shouldBe(interactable, Duration.ofSeconds(15)).click();
        dashboardProjects.shouldBe(interactable, Duration.ofSeconds(15)).click();
    }

    public void dashboardProjectIconClick() {
        dashboardProjectIcon.shouldBe(interactable, Duration.ofSeconds(15)).click();
    }

    public void dashboardTestProjectClick() {
        dashboardProjects.shouldBe(interactable, Duration.ofSeconds(15)).click();
    }
}

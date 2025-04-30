package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement dashboardProjectIcon = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']")
            .as("Вкладка проектов");
    private final SelenideElement dashboardProjects = $x("//ul[@class='aui-nav']//div//a[@href='/browse/TEST']")
            .as("Проекты");
    private final SelenideElement projectsSidebar = $x("//div[@class='aui-sidebar-body']")
            .as("Панель вкладок внутри проекта");

    public void dashboardUse() {
        dashboardProjectIcon.shouldBe(interactable).click();
        dashboardProjects.shouldBe(interactable).click();
        Assertions.assertTrue(projectsSidebar.shouldBe(visible).isDisplayed());
    }
}

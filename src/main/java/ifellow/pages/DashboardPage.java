package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement dashboardProjectIcon = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']").as("Вкладка проектов");
    private final SelenideElement dashboardProjects = $x("//ul[@class='aui-nav']//div//a[@href='/browse/TEST']").as("Проекты");
    private final SelenideElement projectsSidebar = $x("//div[@class='aui-sidebar-body']").as("Панель вкладок внутри проекта");

    public void dashboardUse() {
        dashboardProjectIcon.shouldBe(Condition.interactable).click();
        dashboardProjects.shouldBe(Condition.interactable).click();
    }

    public boolean openProjects() {
        return projectsSidebar.shouldBe(Condition.visible).isDisplayed();
    }
}

package ifellow.cucumber.steps;

import ifellow.pages.DashboardPage;
import ifellow.pages.ProjectPage;
import io.cucumber.java.ru.Тогда;

public class DashboardStep {
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();

    @Тогда("нажимаем на кнопку Проекты")
    public void projectIconClick() {
        dashboardPage.dashboardProjectIconClick();
    }

    @Тогда("нажимаем на кнопку проекта Test")
    public void projectTestProjectClick() {
        dashboardPage.dashboardTestProjectClick();
    }

    @Тогда("проверяем, что открылась страница проекта Test")
    public void projectIsOpen() {
        projectPage.projectPageIsOpen();
    }
}

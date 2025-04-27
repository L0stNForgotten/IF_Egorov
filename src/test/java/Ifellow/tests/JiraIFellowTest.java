package Ifellow.tests;

import org.junit.jupiter.api.*;
import ifellow.pages.*;

public class JiraIFellowTest extends WebHooks {
    @Test
    public void authorizationTest() {
        AuthorizationPage authorization = new AuthorizationPage();
        authorization.authorizationInnit(getDefaultLogin(), getDefaultPassword());
        Assertions.assertTrue(authorization.didAuthorized());
    }

    @Test
    public void dashboardTest() {
        authorizationTest();
        DashboardPage dashboard = new DashboardPage();
        dashboard.dashboardUse();
        Assertions.assertTrue(dashboard.openProjects());
    }

    @Test
    public void projectTest() {
        dashboardTest();
        ProjectPage project = new ProjectPage();
        project.projectCheckFilter();
        int beforeInt = project.projectTasksCountCheck();
        project.projectTaskCreator("Test task input");
        Assertions.assertEquals(beforeInt, project.projectTasksCountCheck());
    }

    @Test
    public void seleniumTaskTest () {

    }
}
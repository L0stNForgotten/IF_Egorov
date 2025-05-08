package Ifellow.tests;

import ifellow.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JiraIFellowTest extends WebHooks {
    private final AuthorizationPage authorization = new AuthorizationPage();
    private final DashboardPage dashboard = new DashboardPage();
    private final ProjectPage project = new ProjectPage();
    private final TaskSeleniumPage taskSelenium = new TaskSeleniumPage();
    private final BugRepoPage bugRepo = new BugRepoPage();
    private final CloseTaskPage closeTask = new CloseTaskPage();

    @Test
    public void authorizationTest() {
        authorization.authorizationInnit(getDefaultLogin(), getDefaultPassword());
        dashboard.dashboardIsOpen();
    }

    @Test
    public void dashboardTest() {
        authorizationTest();
        dashboard.dashboardUse();
        project.projectPageIsOpen();
    }

    @Test
    public void projectTest() {
        dashboardTest();
        project.projectCheckFilter();
        int beforeInt = project.projectTasksCountCheck();
        project.projectTaskCreator("Test task input");
        Assertions.assertEquals(beforeInt + 1, project.projectTasksCountCheck());
    }

    @Test
    public void seleniumTaskTest() {
        projectTest();
        taskSelenium.taskInfoCheck();
        String[] info = taskSelenium.taskInfoGet();
        Assertions.assertTrue(info[0].equalsIgnoreCase("сделать"));
        Assertions.assertTrue(info[1].equalsIgnoreCase("version 2.0"));
    }

    @Test
    public void bugRepoTest() {
        seleniumTaskTest();
        bugRepo.bugRepoGeneration();
    }

    @Test
    public void closeTaskTest() {
        bugRepoTest();
        bugRepo.openCustomBugRepoPage();
        closeTask.closeTaskFromBugRepo();
    }
}
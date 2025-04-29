package Ifellow.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ifellow.pages.*;

public class JiraIFellowTest extends WebHooks {
    private final AuthorizationPage authorization = new AuthorizationPage();
    private final DashboardPage dashboard = new DashboardPage();
    private final ProjectPage project = new ProjectPage();
    private final TaskSeleniumPage taskSelenium = new TaskSeleniumPage();
    private final BugRepoPage bugRepo = new BugRepoPage();

    @Test
    public void authorizationTest() {
        authorization.authorizationInnit(getDefaultLogin(), getDefaultPassword());
        ;
    }

    @Test
    public void dashboardTest() {
        authorizationTest();
        dashboard.dashboardUse();
        ;
    }

    @Test
    public void projectTest() {
        dashboardTest();
        project.projectCheckFilter();
        Selenide.sleep(1500);
        int beforeInt = project.projectTasksCountCheck();
        project.projectTaskCreator("Test task input");
        Selenide.sleep(1500);
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
        bugRepo.repoIssueWasMade();
    }
}
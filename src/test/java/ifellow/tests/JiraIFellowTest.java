package ifellow.tests;

import ifellow.steps.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static ifellow.Config.*;

@DisplayName("JiraTest")
@Epic("Jira Integration and Task Management")
@Feature("End-to-End Jira Workflow Automation")
public class JiraIFellowTest extends WebHooks {
    AuthorizationSteps authorization = new AuthorizationSteps();
    DashboardSteps dashboard = new DashboardSteps();
    ProjectSteps project = new ProjectSteps();
    TaskSeleniumSteps taskSelenium = new TaskSeleniumSteps();
    BugRepoSteps bugRepo = new BugRepoSteps();
    CloseTaskSteps task = new CloseTaskSteps();

    @Test
    @DisplayName("Authorization check")
    @Description("Verify successful user authentication in Jira and dashboard redirection")
    public void autTest() {
        authorization.autInput(JIRA_LOGIN.get(), JIRA_PASSWORD.get());
        authorization.autSignIn();
    }

    @Test
    @DisplayName("Dashboard check")
    @Description("Validate navigation from dashboard to project section via UI interactions")
    public void dashTest(){
        autTest();
        dashboard.dashClickOnIcon();
        dashboard.dashClickOnProject();
    }

    @Test
    @DisplayName("Counting tasks")
    @Description("Check project validate project count before/after functionality")
    public void projTest(){
        dashTest();
        project.projFiltering();
        project.projCountBefore();
        project.projCountAfterCheck("test");
    }

    @Test
    @DisplayName("Verifying task details")
    @Description("Verify task details in the Selenium project")
    public void taskselTest(){
        projTest();
        taskSelenium.taskOpenList();
        taskSelenium.taskCheckTitleAndFind("TestSeleniumATHomework");
        taskSelenium.taskCheckStatus("Сделать","Version 2.0");
    }

    @Test
    @DisplayName("Creating bug report")
    @Description("Create a bug report with all mandatory fields")
    public void bugrepTest(){
        taskselTest();
        bugRepo.bugrepOpenCreatorIssue();
        bugRepo.bugrepChooseType();
        bugRepo.bugrepInputTopic("Allure test HW6");
        bugRepo.bugrepInputDescription("Text text text");
        bugRepo.bugrepChooseFixVersion();
        bugRepo.bugrepChangePriority();
        bugRepo.bugrepChooseMark();
        bugRepo.bugrepInputEnvironment("Text1 Text1 Text1");
        bugRepo.bugrepChooseEnvVersion();
        bugRepo.bugrepChooseRelatedTasks();
        bugRepo.bugrepChooseTask();
        bugRepo.bugrepChooseAssignment();
        bugRepo.bugrepChooseEpic();
        bugRepo.bugrepChooseSprint();
        bugRepo.bugrepChangeSeverity();
        bugRepo.bugrepCreateTask();
        bugRepo.bugrepCheckCreation();
    }

    @Test
    @DisplayName("Closing bug report")
    @Description("Validate task transition to 'In Progress' and 'Done' statuses")
    public void closeTaskTest () {
        bugrepTest();
        task.taskOpenCreatedTask();
        task.taskInProgress();
        task.taskDone();
    }
}
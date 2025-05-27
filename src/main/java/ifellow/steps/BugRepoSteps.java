package ifellow.steps;

import io.qameta.allure.Step;

public class BugRepoSteps extends StepsData {
    @Step("Open issue creation form")
    public void bugrepOpenCreatorIssue() {
        log.info("Opening issue creation form");
        getBugRepo().createIssueButtonClick();
        log.info("Issue creation form opened successfully");
    }

    @Step("Select issue type")
    public void bugrepChooseType() {
        log.info("Selecting issue type");
        getBugRepo().issueTypeFieldInput();
        log.info("Issue type selected successfully");
    }

    @Step("Enter issue topic: {topic}")
    public void bugrepInputTopic(String topic) {
        log.info("Entering issue topic: {}", topic);
        getBugRepo().issueTopicInput(topic);
        log.info("Issue topic entered successfully");
    }

    @Step("Enter issue description")
    public void bugrepInputDescription(String text) {
        log.info("Entering issue description");
        getBugRepo().issueDescriptionInput(text);
        log.info("Issue description entered successfully");
    }

    @Step("Select fix version")
    public void bugrepChooseFixVersion() {
        log.info("Selecting fix version");
        getBugRepo().issueFixVersionChoice();
        log.info("Fix version selected successfully");
    }

    @Step("Change issue priority")
    public void bugrepChangePriority() {
        log.info("Changing issue priority");
        getBugRepo().changeIssuePriority();
        log.info("Issue priority changed successfully");
    }

    @Step("Select issue marks")
    public void bugrepChooseMark() {
        log.info("Selecting issue marks");
        getBugRepo().issueMarksFieldChoice();
        log.info("Issue marks selected successfully");
    }

    @Step("Enter environment details: {text}")
    public void bugrepInputEnvironment(String text) {
        log.info("Entering environment details");
        getBugRepo().issueEnvironmentDescriptionInput(text);
        log.info("Environment details entered successfully");
    }

    @Step("Select environment version")
    public void bugrepChooseEnvVersion() {
        log.info("Selecting environment version");
        getBugRepo().issueEnvironmentVersionChoice();
        log.info("Environment version selected successfully");
    }

    @Step("Select related tasks")
    public void bugrepChooseRelatedTasks() {
        log.info("Selecting related tasks");
        getBugRepo().issueRelatedTaskChoice();
        log.info("Related tasks selected successfully");
    }

    @Step("Select task")
    public void bugrepChooseTask() {
        log.info("Selecting task");
        getBugRepo().issueTaskChoiceInput();
        log.info("Task selected successfully");
    }

    @Step("Assign issue")
    public void bugrepChooseAssignment() {
        log.info("Assigning issue");
        getBugRepo().issueAssignment();
        log.info("Issue assigned successfully");
    }

    @Step("Select epic")
    public void bugrepChooseEpic() {
        log.info("Selecting epic");
        getBugRepo().issueEpicChoiceClick();
        log.info("Epic selected successfully");
    }

    @Step("Select sprint")
    public void bugrepChooseSprint() {
        log.info("Selecting sprint");
        getBugRepo().issueSprintChoiceClick();
        log.info("Sprint selected successfully");
    }

    @Step("Change issue severity")
    public void bugrepChangeSeverity() {
        log.info("Changing issue severity");
        getBugRepo().changeIssueSeverity();
        log.info("Issue severity changed successfully");
    }

    @Step("Create new task")
    public void bugrepCreateTask() {
        log.info("Creating new task");
        getBugRepo().createIssueBugRepo();
        log.info("Task created successfully");
    }

    @Step("Verify task creation")
    public void bugrepCheckCreation() {
        log.info("Verifying task creation");
        getBugRepo().checkIssueCreate();
        log.info("Task creation verified successfully");
    }
}

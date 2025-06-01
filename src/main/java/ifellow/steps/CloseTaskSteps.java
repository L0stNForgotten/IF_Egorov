package ifellow.steps;

import ifellow.config.StepsData;
import io.qameta.allure.Step;

public class CloseTaskSteps extends StepsData {
    @Step("Open previously created task")
    public void taskOpenCreatedTask() {
        log.info("Opening the created task");
        getBugRepo().openCustomBugRepoPage();
        log.info("Task opened successfully");
    }

    @Step("Change task status to 'In Progress'")
    public void taskInProgress() {
        log.info("Changing task status to 'In Progress'");
        getCloseTask().closeTaskInProgressState();
        log.info("Task status changed to 'In Progress' successfully");
    }

    @Step("Change task status to 'Done'")
    public void taskDone() {
        log.info("Changing task status to 'Done'");
        getCloseTask().closeTaskDone();
        log.info("Task status changed to 'Done' successfully");
    }
}

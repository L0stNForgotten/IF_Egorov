package ifellow.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class TaskSeleniumSteps extends StepsData {

    @Step("Open task list view")
    public void taskOpenList() {
        log.info("Opening task list view");
        getProject().taskListButtonClick();
        log.info("Task list view opened successfully");
    }

    @Step("Verify task title and search for: {input}")
    public void taskCheckTitleAndFind(String input) {
        log.info("Starting task verification and search process");
        log.info("Checking task title");
        getTaskSelenium().taskTitleCheck();
        log.info("Inputting search text: {}", input);
        getTaskSelenium().taskInputField(input);
        log.info("Opening task details");
        getTaskSelenium().testingTaskInfoClick();
        log.info("Verifying task information");
        getTaskSelenium().testingTaskInfoCheck();
        log.info("Task verification and search completed successfully");
    }

    @Step("Verify task status and version - Expected status: {status}, version: {version}")
    public void taskCheckStatus(String status, String version) {
        log.info("Verifying task status and version");
        log.info("Expected status: {}, version: {}", status, version);
        String[] data = getTaskSelenium().taskInfoGet();
        log.info("Actual status: {}, version: {}", data[0], data[1]);
        Assertions.assertTrue(data[0].equalsIgnoreCase(status));
        Assertions.assertTrue(data[1].equalsIgnoreCase(version));
        log.info("Task status and version verification passed");
    }
}

package ifellow.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class ProjectSteps extends StepsData {
    private int beforeInt;

    @Step("Apply filters to project tasks")
    public void projFiltering() {
        log.info("Applying filters to project tasks");
        getProject().projectCheckFilter();
        log.info("Filters applied successfully");
    }

    @Step("Record initial task count before creation")
    public void projCountBefore() {
        log.info("Checking initial task count");
        beforeInt = getProject().projectTasksCountCheck();
        log.info("Initial task count recorded: {}", beforeInt);
    }

    @Step("Verify task count after creating new task: {name}")
    public void projCountAfterCheck(String name){
        log.info("Creating new task with name: {}", name);
        getProject().projectTaskCreator(name);
        log.info("Task count verification");
        Assertions.assertEquals(beforeInt,getProject().projectTasksCountCheck()-1);
        log.info("Task count verification passed successfully");
    }

}

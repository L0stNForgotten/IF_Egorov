package ifellow.steps;

import ifellow.config.StepsData;
import io.qameta.allure.Step;

public class DashboardSteps extends StepsData {
    @Step("Click on project icon in dashboard")
    public void dashClickOnIcon() {
        log.info("Clicking on project icon in dashboard");
        getDashboard().dashboardProjectIconClick();
        log.info("Project icon clicked successfully");
    }

    @Step("Select and open test project from dashboard")
    public void dashClickOnProject() {
        log.info("Selecting test project from dashboard");
        getDashboard().dashboardTestProjectClick();
        log.info("Verifying project page opened");
        getProject().projectPageIsOpen();
        log.info("Test project opened successfully");
    }
}

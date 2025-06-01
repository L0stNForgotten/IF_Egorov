package ifellow.steps;

import ifellow.config.StepsData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class AuthorizationSteps extends StepsData {
    public void autInput(String login, String password) {
        Allure.step("Input login and password", () -> {
            getAuthorization().authorizationInnit(login, password);
            log.info("Authorization input was success");
        });
    }

    @Step("Click sign in button and check")
    public void autSignIn() {
        getAuthorization().loginButtonClick();
        getDashboard().dashboardIsOpen();
        log.info("Sign in was success");
    }
}

package ifellow.steps;

import io.qameta.allure.Step;

public class AuthrizationSteps extends StepsConfig {

    @Step("Authorization: Input login and password")
    public void autInput (String login, String password) {
        log.info("Authorization input: login - {}, password - {}", login, password);
        try {
            authorization.authorizationInnit(login, password);
            log.info("Authorization input was success");
        } catch (Exception e) {
            log.info("Authorization input wasn't success.");
        }
    }

    @Step("Authorization: Click sign in button and check")
    public void autSignIn () {
        try {
            authorization.loginButtonClick();
            dashboard.dashboardIsOpen();
            log.info("Sign in was success");
        } catch (Exception e) {
            log.info("Sign in wasn't success");
        }
    }

}

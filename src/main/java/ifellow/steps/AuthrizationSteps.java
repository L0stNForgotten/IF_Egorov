package ifellow.steps;

import io.qameta.allure.Step;

public class AuthrizationSteps extends StepsConfig {

    @Step("Authorization: Input login and password")
    public void autInput (String login, String password) {
        log.info("Authorization input: login - {}, password - {}", login, password);
        authorization.authorizationInnit(login, password);
        log.info("Authorization input was success");
    }

    @Step("Authorization: Click sign in button and check")
    public void autSignIn () {
        authorization.loginButtonClick();
        dashboard.dashboardIsOpen();
        log.info("Sign in was success");
    }

}

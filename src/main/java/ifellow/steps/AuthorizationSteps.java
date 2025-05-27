package ifellow.steps;

import io.qameta.allure.Step;

public class AuthorizationSteps extends StepsData {
    @Step("Input login and password")
    public void autInput (String login, String password) {
        log.info("Authorization input: login - {}, password - {}", login, password);
        getAuthorization().authorizationInnit(login, password);
        log.info("Authorization input was success");
    }

    @Step("Click sign in button and check")
    public void autSignIn () {
        getAuthorization().loginButtonClick();
        getDashboard().dashboardIsOpen();
        log.info("Sign in was success");
    }
}

package ifellow.tests;

import ifellow.steps.*;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;


public class JiraIFellowTest extends WebHooks {
    AuthrizationSteps authrizationSteps = new AuthrizationSteps();

    @Feature(value = "Проерка авторизации")
    @Test
    public void autTest() {
        authrizationSteps.autInput("AT5","Qwerty123");
        authrizationSteps.autSignIn();
    }
}
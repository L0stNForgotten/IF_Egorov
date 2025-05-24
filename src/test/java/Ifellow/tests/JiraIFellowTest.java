package Ifellow.tests;

import ifellow.steps.*;
import org.junit.jupiter.api.Test;

public class JiraIFellowTest extends WebHooks {
    AuthrizationSteps authrizationSteps = new AuthrizationSteps();

    @Test
    public void autTest() {
        authrizationSteps.autInput(getDefaultLogin(),getDefaultPassword());
        authrizationSteps.autSignIn();
    }
}
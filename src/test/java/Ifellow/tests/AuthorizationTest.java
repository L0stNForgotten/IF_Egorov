package Ifellow.tests;

import org.junit.jupiter.api.Test;
import ifellow.pages.*;

public class AuthorizationTest extends WebHooks {
    @Test
    public void authorizationTest() {
        AuthorizationPage test = new AuthorizationPage();
        test.authorizationPageCheck(getDefaultLogin(),getDefaultPassword());
    }
}

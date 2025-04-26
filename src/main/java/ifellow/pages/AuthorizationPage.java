package ifellow.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private final SelenideElement authorizationContainer = $x("//div[@id='login-container']");
    private final SelenideElement authorizationLoginInput = $x("//div[@id='login-container']//input[@id='login-form-username']");
    private final SelenideElement authorizationPasswordInput = $x("//div[@id='login-container']//input[@id='login-form-password']");
    private final SelenideElement authorizationButton = $x("//div[@id='login-container']//div[@class='buttons-container']//input[@value='Войти']");

    public void authorizationPageCheck(String login, String password) {
        SelenideElement[] content = {
                authorizationContainer,
                authorizationLoginInput,
                authorizationPasswordInput,
                authorizationButton
        };

        for (SelenideElement element : content)
            element.shouldBe(Condition.visible);

        authorizationLoginInput.sendKeys(login);
        authorizationPasswordInput.sendKeys(password);
        authorizationButton.pressEnter();
    }
}
package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    private final SelenideElement authorizationLoginInput = $x("//div[@id='login-container']//input[@id='login-form-username']")
            .as("Строка ввода имени");
    private final SelenideElement authorizationPasswordInput = $x("//div[@id='login-container']//input[@id='login-form-password']")
            .as("Строка ввода пароля");
    private final SelenideElement authorizationButton = $x("//div[@id='login-container']//div[@class='buttons-container']//input[@value='Войти']")
            .as("Кнопка входа");

    public void authorizationInnit(String login, String password) {
        authorizationLoginInput.shouldBe(interactable, Duration.ofSeconds(15)).sendKeys(login);
        authorizationPasswordInput.shouldBe(interactable).sendKeys(password);
        authorizationButton.shouldBe(interactable).click();
    }
}

package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private final SelenideElement authorizationLoginInput = $x("//div[@id='login-container']//input[@id='login-form-username']")
            .as("Строка ввода имени");
    private final SelenideElement authorizationPasswordInput = $x("//div[@id='login-container']//input[@id='login-form-password']")
            .as("Строка ввода пароля");
    private final SelenideElement authorizationButton = $x("//div[@id='login-container']//div[@class='buttons-container']//input[@value='Войти']")
            .as("Кнопка входа");
    private final SelenideElement dashboardProjectTab = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']")
            .as("Дэшборд вкладка проекты");

    public void authorizationInnit(String login, String password) {

        authorizationLoginInput.shouldBe(interactable).sendKeys(login);
        authorizationPasswordInput.shouldBe(interactable).sendKeys(password);
        authorizationButton.shouldBe(interactable).click();
        Assertions.assertTrue(dashboardProjectTab.shouldBe(visible).isDisplayed());
    }

}

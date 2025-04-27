package ifellow.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    private final SelenideElement authorizationLoginInput = $x("//div[@id='login-container']//input[@id='login-form-username']").as("Строка ввода имени");
    private final SelenideElement authorizationPasswordInput = $x("//div[@id='login-container']//input[@id='login-form-password']").as("Строка ввода пароля");
    private final SelenideElement authorizationButton = $x("//div[@id='login-container']//div[@class='buttons-container']//input[@value='Войти']").as("Кнопка входа");
    private final SelenideElement dashboardProjectTab = $x("//header[@role='banner']//ul[@class='aui-nav']//a[@id='browse_link']").as("Дэшборд вкладка проекты");

    public void authorizationInnit(String login, String password) {

        authorizationLoginInput.shouldBe(Condition.visible).shouldBe(Condition.enabled).shouldBe(Condition.interactable).sendKeys(login);
        authorizationPasswordInput.shouldBe(Condition.visible).shouldBe(Condition.enabled).shouldBe(Condition.interactable).sendKeys(password);
        authorizationButton.shouldBe(Condition.interactable).click();
    }

    public boolean didAuthorized() {
        return dashboardProjectTab.shouldBe(Condition.visible).isDisplayed();
    }
}

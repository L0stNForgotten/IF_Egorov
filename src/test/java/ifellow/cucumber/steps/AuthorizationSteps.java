package ifellow.cucumber.steps;
import ifellow.pages.*;
import io.cucumber.java.ru.*;
import org.junit.jupiter.api.DisplayName;

public class AuthorizationSteps {
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @DisplayName("Тест авторизации.")

    @Когда("вводим данные {string} и {string}")
    public void authorizationInnitStep (String login, String password) { authorizationPage.authorizationInnit(login, password); }

    @Тогда("^проверяем, что открылась главная страница")
    public void checkAuthorizationStep () { dashboardPage.dashboardIsOpen(); }
}

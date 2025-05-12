package ifellow.cucumber.steps;
import ifellow.pages.*;
import io.cucumber.java.ru.*;

public class AuthorizationSteps {
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Когда("вводим данные авторизации {string} и {string}")
    public void authorizationInnitStep (String login, String password) { authorizationPage.authorizationInnit(login, password); }

    @Тогда("нажимаем Войти")
    public void loginButtonClick () { authorizationPage.loginButtonClick(); }

    @Тогда("проверяем, что открылась главная страница")
    public void checkAuthorizationStep () { dashboardPage.dashboardIsOpen(); }
}

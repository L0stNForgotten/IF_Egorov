package ifellow.steps;

import ifellow.api.rnm.RnM_api;
import ifellow.api_steps.RnM_api_steps;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import java.util.Map;

@Epic("Проверка корректности работы Rick and Morty Api")
@Feature("Тестирование обработки данных полученных запросов")
@Slf4j
public class RnM_steps extends RnM_api {
    final private RnM_api_steps api_steps = new RnM_api_steps();
    private JsonPath morty;
    private JsonPath episode;
    private JsonPath last_person;

    @Step("Получение персонажа по id")
    @Когда("получаем персонажа по id: {int}")
    public void getPerson(Integer id) {
        this.morty = infoObject("/character/2", "status", "Alive");
        log.info("Person \"{}\" was found by id.", this.morty.getString("name"));
    }

    @Step("Проверка данного персонажа")
    @Тогда("проверяем, что персонажа зовут {string}")
    public void checkPerson(String name) {
        Assertions.assertTrue(this.morty.getString("name").equalsIgnoreCase(name));
        log.info("Person \"{}\" was checked.", this.morty.getString("name"));
    }

    @Step("Выбор последнего эпизода")
    @Тогда("выбираем поседний эпизод, где встречался этот персонаж и сравниваем с {string}")
    public void getEpisode(String episode) {
        this.episode = parserInsideInfo(morty, "episode");
        Assertions.assertTrue(this.episode.getString("episode").equalsIgnoreCase(episode));
        log.info("Episode \"{}\" was found.", this.episode.getString("name"));
    }

    @Step("Выбор последнего персонажа")
    @Тогда("выбираем последнего персонажа этого эпизода и проверяем, что это {string}")
    public void getLast_person(String name) {
        this.last_person = parserInsideInfo(this.episode, "characters");
        Assertions.assertTrue(this.last_person.getString("name").equalsIgnoreCase(name));
        log.info("Episode's last person \"{}\" was found.", this.last_person.getString("name"));
    }

    @Step("Выбор локации последнего персонажа")
    @Тогда("выбираем локацию где сейчас находится этот персонаж и проверяем, что это {string}")
    public void getLpLocation(String location) {
        JsonPath lp_location = parserInsideInfo(this.last_person, "location");
        Assertions.assertTrue(lp_location.getString("name").equalsIgnoreCase(location));
        log.info("Location of {} - {}", this.last_person.getString("name"), lp_location.getString("name"));
    }

    @Step("Сравнение данного и полученного персонажей")
    @Тогда("сравниваем данного и полученного персонажей по рассе и местонахождению")
    public void comparison() {
        Map<String, String>[] data = api_steps.getRaceAndLocation(this.morty, this.last_person);
        api_steps.comparisonOfInfo(data, this.morty, this.last_person);
    }
}
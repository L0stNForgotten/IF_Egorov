package ifellow.steps;

import ifellow.api_steps.Reqres_api_steps;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import java.util.Map;

@Slf4j
@Epic("Проверка корректности работы reqres")
@Feature("Тестирование работы с json файлами и отправления запросов")
public class Reqres_steps {
    private final Reqres_api_steps api_steps = new Reqres_api_steps();
    private JsonPath jpath;
    private Map<String, Object> upData;

    @Step("Получение данных из json файла")
    @Когда("получаем данные из {string}")
    public void getJsonData(String jsonFile) {
        this.jpath = this.api_steps.getDataJson(jsonFile);
        Assertions.assertNotNull(this.jpath, "Не удалось загрузить JSON из файла: " + jsonFile);
    }

    @Step("Проверка полученных данных")
    @Тогда("проверяем полученные данные по ключу name с {string}")
    public void checkJsonData(String expected_value) {
        Assertions.assertNotNull(this.jpath, "JSON данные не были загружены");
        Assertions.assertEquals(expected_value, this.jpath.get("name"),
                "Значение поля 'name' не соответствует ожидаемому");
    }

    @Step("Обновление полученных данных")
    @Тогда("обновляем полученные данные по ключу name на {string} и добавляем {string} для ключа job")
    public void updateData(String name, String job) {
        Assertions.assertNotNull(this.jpath, "JSON данные не были загружены");
        this.upData = api_steps.refData(this.jpath, name, job);
        Assertions.assertNotNull(this.upData, "Не удалось обновить данные");
    }

    @Step("Сравнение обновлённых данных с полученными")
    @Тогда("проверяем, что обновлённые данные не совпадают с исходными")
    public void checkUpdates() {
        Assertions.assertNotNull(this.jpath, "Исходные JSON данные не были загружены");
        Assertions.assertNotNull(this.upData, "Обновлённые данные не были созданы");

        log.info("Original data: {}", this.jpath.getMap(""));
        log.info("Updated data: {}", this.upData);

        Assertions.assertNotEquals(
                this.jpath.getMap(""),
                this.upData,
                "Ожидалось, что обновлённые данные будут отличаться от исходных"
        );
    }

    @Step("Отправка POST запроса на сервер")
    @Тогда("отправляем POST запрос обновлённых данных")
    public void postUpdates() {
        log.info("Posting data: {}", this.upData);
        api_steps.postDataInUsers(this.upData);
    }
}

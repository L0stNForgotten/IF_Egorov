package ifellow.steps;

import ifellow.api_steps.Reqres_api_steps;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import java.util.Map;

@Slf4j
public class Reqres_steps {
    private final Reqres_api_steps api_steps = new Reqres_api_steps();
    private JsonPath jpath;
    private Map<String, Object> upData;

    @Story("Получение данных пользователя")
    @Step("Получение данных из json файла '{jsonFile}'")
    @Когда("получаем данные из {string}")
    public void getJsonData(String jsonFile) {
        this.jpath = this.api_steps.getDataJson(jsonFile);
        Assertions.assertNotNull(this.jpath, "Не удалось загрузить JSON из файла: " + jsonFile);
        log.info("Successfully loaded data from {}", jsonFile);
    }

    @Story("Валидация данных пользователя")
    @Step("Проверка что поле 'name' содержит значение '{expected_value}'")
    @Тогда("проверяем полученные данные по ключу name с {string}")
    public void checkJsonData(String expected_value) {
        Assertions.assertNotNull(this.jpath, "JSON данные не были загружены");
        String actualName = this.jpath.get("name");
        Assertions.assertEquals(expected_value, actualName,
                String.format("Значение поля 'name' должно быть '%s', но было '%s'",
                        expected_value, actualName));
    }

    @Story("Модификация данных пользователя")
    @Step("Обновление данных пользователя: name='{name}', job='{job}'")
    @Тогда("обновляем полученные данные по ключу name на {string} и добавляем {string} для ключа job")
    public void updateData(String name, String job) {
        Assertions.assertNotNull(this.jpath, "JSON данные не были загружены");
        log.debug("Updating user data. New name: {}, new job: {}", name, job);
        this.upData = api_steps.refData(this.jpath, name, job);
        Assertions.assertNotNull(this.upData, "Не удалось обновить данные");
    }

    @Story("Валидация обновленных данных")
    @Step("Сравнение обновлённых данных с оригинальными")
    @Тогда("проверяем, что обновлённые данные не совпадают с исходными")
    public void checkUpdates() {
        Assertions.assertNotNull(this.jpath, "Исходные JSON данные не были загружены");
        Assertions.assertNotNull(this.upData, "Обновлённые данные не были созданы");

        Map<String, Object> originalData = this.jpath.getMap("");
        log.debug("Original data: {}", originalData);
        log.debug("Updated data: {}", this.upData);

        Assertions.assertNotEquals(originalData, this.upData,
                "Ожидалось, что обновлённые данные будут отличаться от исходных");
    }

    @Story("Отправка данных на сервер")
    @Step("Отправка POST запроса с обновлёнными данными")
    @Тогда("отправляем POST запрос обновлённых данных")
    public void postUpdates() {
        log.info("Posting updated data to server: {}", this.upData);
        api_steps.postDataInUsers(this.upData);
    }
}

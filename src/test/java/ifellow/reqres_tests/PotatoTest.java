package ifellow.reqres_tests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import ifellow.steps.reqres.Reqres_steps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static ifellow.api.reqres.Reqres_specification.baseResponse;
import static io.restassured.RestAssured.given;

public class PotatoTest extends Reqres_steps {

    public Map<String, Object> jsonMapGetter(String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/test/resources/"+jsonFile);
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл или распарсить JSON: " + e.getMessage(), e);
        }
    }

    @Test
    public void test () {
        Map<String, Object> potatoJson = jsonMapGetter("potato.json");
        potatoJson.replace("name", "Tomato");
        potatoJson.put("job", "Eat maket");
        Response response = (Response) given()
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(potatoJson).post();

        System.out.println(response.jsonPath().getString("name"));
        System.out.println(response.jsonPath().getString("job"));

    }
}
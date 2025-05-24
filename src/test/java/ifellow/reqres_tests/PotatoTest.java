package ifellow.reqres_tests;

import ifellow.api.reqres.Reqres_api;
import ifellow.steps.reqres.Reqres_steps;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PotatoTest extends Reqres_api {
    private final Reqres_steps steps = new Reqres_steps();
    private final String name = "Tomato";
    private final String job = "Eat maket";

    @DisplayName("Getter: Data from Json file.")
    @Test
    public void potatoData() {
        log.info("Data gotten: {}", steps.getDataJson("potato.json").getMap(""));
    }

    @DisplayName("Setter: Update body data.")
    @Test
    public void updPotato() {
        JsonPath potato = steps.getDataJson("potato.json");
        log.info("Data updated: {}", steps.refData(potato, name, job));
    }

    @DisplayName("Post: Data from updated body.")
    @Test
    public void postTomato() {
        JsonPath potato = steps.getDataJson("potato.json");
        Map<String, Object> tomato = steps.refData(potato, name, job);
        log.info("Status code: {}", steps.postDataInUsers(tomato).getStatusCode());
    }

    @DisplayName("Check: Check response data match.")
    @Test
    public void checkValidation() {
        log.info("Getting data.");
        JsonPath potato = steps.getDataJson("potato.json");
        Map<String, Object> tomato = steps.refData(potato, name, job);
        Response response = steps.postDataInUsers(tomato);
        log.info("Posted data: {}", tomato);
        log.info("Status Code: {}", response.getStatusCode());
        log.info("Check for match.");
        Assertions.assertTrue(response.jsonPath().getString("name").equalsIgnoreCase(name), "Name doesn't match.");
        Assertions.assertTrue(response.jsonPath().getString("job").equalsIgnoreCase(job), "Job doesn't match.");
        log.info("Match success.");
    }
}
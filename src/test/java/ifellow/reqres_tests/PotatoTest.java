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
        System.out.println("Data gotten: " + steps.getDataJson("potato.json"));
    }

    @DisplayName("Setter: Update body data.")
    @Test
    public void updPotato() {
        JsonPath potato = steps.getDataJson("potato.json");
        System.out.println("Data updated: " + steps.refData(potato, name, job));
    }

    @DisplayName("Post: Data from updated body.")
    @Test
    public void postTomato() {
        JsonPath potato = steps.getDataJson("potato.json");
        Map<String, Object> tomato = steps.refData(potato, name, job);
        System.out.println("Status code: " + steps.postDataInUsers(tomato).getStatusCode());
    }

    @DisplayName("Check: Check response data match.")
    @Test
    public void checkValidation() {
        System.out.println("Getting data.");
        JsonPath potato = steps.getDataJson("potato.json");
        Map<String, Object> tomato = steps.refData(potato, name, job);
        Response response = steps.postDataInUsers(tomato);
        System.out.println("Posted data: " + tomato);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Check for match.");
        Assertions.assertTrue(response.jsonPath().getString("name").equalsIgnoreCase(name));
        Assertions.assertTrue(response.jsonPath().getString("job").equalsIgnoreCase(job));
        System.out.println("Match success.");
    }
}
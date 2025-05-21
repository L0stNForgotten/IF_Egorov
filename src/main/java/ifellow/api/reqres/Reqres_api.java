package ifellow.api.reqres;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.util.Map;

import static ifellow.api.reqres.Reqres_specification.baseRequest;

public abstract class Reqres_api {

    @BeforeAll
    public static void init() {
        RestAssured.requestSpecification = baseRequest(
                "https://reqres.in/api/",
                "x-api-key",
                "reqres-free-v1");
        System.out.println("Start of test case.");
        System.out.println("Test requests to https://reqres.in servers");
    }

    @AfterEach
    public void endOfTests() {
        System.out.println("Test end.\n");
    }

    @AfterAll
    public static void endOfTestCase() {
        System.out.println("End of test case.");
    }

    public static JsonPath jsonPathGetter(String jsonFile) {
        return JsonPath.from(new File("src/test/resources/" + jsonFile));
    }

    public Map<String, Object> refJsonData(JsonPath obj, String key, String value) {
        Map<String, Object> objData = obj.getMap("");
        return refJsonData(objData, key, value);
    }

    public Map<String, Object> refJsonData(Map<String, Object> obj, String key, String value) {
        obj.replace(key, value);
        return obj;
    }
}

package ifellow.api.rnm;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ifellow.api.rnm.RnM_specification.baseRequest;
import static ifellow.api.rnm.RnM_specification.baseResponse;
import static io.restassured.RestAssured.given;

public abstract class RnM_api {
    @BeforeAll
    public static void init() {
        RestAssured.requestSpecification = baseRequest("https://rickandmortyapi.com/api/");
        RestAssured.responseSpecification = baseResponse(200);
        System.out.println("Start of test case.");
        System.out.println("Test requests to https://rickandmortyapi.com servers");
    }

    @AfterEach
    public void endOfTests() {
        System.out.println("Test end.\n");
    }

    @AfterAll
    public static void endOfTestCase() {
        System.out.println("End of test case.");
    }

    public static Map<String, Object> infoObject(String path_filter, String keyToCheck, String valueToCheck) {
        return given().when().get(path_filter)
                .then()
                .body(keyToCheck, Matchers.is(valueToCheck))
                .extract().path("");
    }

    public static Map<String, Object> parserInsideInfo(Map<String, Object> subject, String key) {
        return parserInsideInfo(subject, key, -1);
    }

    public static Map<String, Object> parserInsideInfo(Map<String, Object> subject, String key, Integer id) {
        Map<String, Object> outObj = new HashMap<>();
        if (subject.get(key) instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, String> type_map = (Map<String, String>) subject.get(key);
            outObj = given().spec(baseRequest(type_map.get("url")))
                    .when().get()
                    .then().extract().path("");
        } else if (subject.get(key) instanceof List) {
            @SuppressWarnings("unchecked")
            List<String> urls_list = (List<String>) subject.get(key);
            if (id < 0) {
                id = urls_list.size() + id;
            }
            outObj = given().spec(baseRequest(urls_list.get(id)))
                    .when().get()
                    .then().extract().path("");
        }
        return outObj;
    }

    public static String checkEqualsAndNotEquals(Map<String, Object> object1, Map<String, Object> object2, String param) {
        return checkEqualsAndNotEquals((String) object1.get(param), (String) object2.get(param));
    }

    public static String checkEqualsAndNotEquals(String object1, String object2) {
        if (object1.equals(object2)) {
            Assertions.assertEquals(object1, object2);
            return (" are equals.");
        } else {
            Assertions.assertNotEquals(object1, object2);
            return (" are not equals.");
        }
    }
}

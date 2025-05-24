package ifellow.api.rnm;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static ifellow.api.ApiConfig.RNM_URL;
import static ifellow.api.rnm.RnM_specification.baseRequest;
import static ifellow.api.rnm.RnM_specification.baseResponse;
import static io.restassured.RestAssured.given;

public abstract class RnM_api {

    public static final Logger log = LoggerFactory.getLogger(RnM_api.class);

    @BeforeAll
    public static void init() {
        log.info("Start of test case.");
        log.info("Test requests to {} servers", RNM_URL.get());
        RestAssured.requestSpecification = baseRequest(RNM_URL.get());
        RestAssured.responseSpecification = baseResponse(200);
    }

    @AfterEach
    public void endOfTests() {
        log.info("Test end.");
    }

    @AfterAll
    public static void endOfTestCase() {
        log.info("End of test case.");
    }

    public static JsonPath infoObject(String path_filter, String keyToCheck, String valueToCheck) {
        return given().when().get(path_filter)
                .then()
                .body(keyToCheck, Matchers.is(valueToCheck))
                .extract().jsonPath();
    }

    public static JsonPath parserInsideInfo(JsonPath subject, String key) {
        return parserInsideInfo(subject, key, -1);
    }

    public static JsonPath parserInsideInfo(JsonPath subject, String key, Integer id) {
        JsonPath outObj = null;

        Object extracted = subject.get(key);

        if (extracted instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, String> type_map = (Map<String, String>) extracted;
            outObj = given().spec(baseRequest(type_map.get("url")))
                    .when().get()
                    .then().extract().jsonPath();
        } else if (extracted instanceof List) {
            @SuppressWarnings("unchecked")
            List<String> urls_list = (List<String>) extracted;
            if (id < 0) {
                id = urls_list.size() + id;
            }
            outObj = given().spec(baseRequest(urls_list.get(id)))
                    .when().get()
                    .then().extract().jsonPath();
        }

        return outObj;
    }

    public static String checkEqualsAndNotEquals(String object1, String object2) {
        if (object1.equals(object2)) {
            Assertions.assertEquals(object1, object2);
            return " are equals.";
        } else {
            Assertions.assertNotEquals(object1, object2);
            return " are not equals.";
        }
    }
}

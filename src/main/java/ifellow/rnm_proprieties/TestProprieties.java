package ifellow.rnm_proprieties;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ifellow.Specification.baseRequest;
import static io.restassured.RestAssured.given;

public abstract class TestProprieties {
    public Map<String, Object> infoObject(String path_filter, String nameToCheck) {
        return given().when().get(path_filter)
                .then()
                .body("name", Matchers.is(nameToCheck))
                .extract().path("");
    }

    public Map<String, Object> parserInsideInfo(Map<String, Object> subject, String key) {
        return parserInsideInfo(subject, key, -1);
    }

    public Map<String, Object> parserInsideInfo(Map<String, Object> subject, String key, Integer id) {
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

    public String checkEqualsAndNotEquals(Map<String, Object> object1, Map<String, Object> object2, String param) {
        return checkEqualsAndNotEquals((String) object1.get(param), (String) object2.get(param));
    }

    public String checkEqualsAndNotEquals(String object1, String object2) {
        if (object1.equals(object2)) {
            Assertions.assertEquals(object1, object2);
            return (" are equals.");
        } else {
            Assertions.assertNotEquals(object1, object2);
            return (" are not equals.");
        }
    }
}

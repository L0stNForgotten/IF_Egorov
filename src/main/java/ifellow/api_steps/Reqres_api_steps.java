package ifellow.api_steps;

import ifellow.api.reqres.Reqres_api;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Reqres_api_steps extends Reqres_api {
    public static final Logger log = LoggerFactory.getLogger(Reqres_api.class);

    public JsonPath getDataJson(String file) {
        return jsonPathGetter(file);
    }


    public Map<String, Object> refData(JsonPath obj, String name, String job) {
        Map<String, Object> uObj = new HashMap<>(obj.getMap(""));
        uObj.replace("name", name);
        log.info("Name was replaced/created. Name - {}", uObj.get("name"));
        uObj.put("job", job);
        log.info("Job was replaced/created. Job - {}", uObj.get("job"));
        return uObj;
    }

    public void postDataInUsers(Map<String, Object> data) {
        Response response = given()
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(data)
                .when().post();
        response.then().statusCode(201);
    }

}

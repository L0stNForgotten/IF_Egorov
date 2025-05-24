package ifellow.steps.reqres;

import ifellow.api.reqres.Reqres_api;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Reqres_steps extends Reqres_api {
    public JsonPath getDataJson(String file) {
        return jsonPathGetter(file);
    }

    public Map<String, Object> refData(JsonPath obj, String name, String job) {
        Map<String, Object> uObj = obj.getMap("");
        uObj.replace("name", name);
        log.info("Name was replaced/created. Name - {}", uObj.get("name"));
        uObj.put("job", job);
        log.info("Job was replaced/created. Job - {}", uObj.get("job"));
        return uObj;
    }

    public Response postDataInUsers(Map<String, Object> data) {
        Response response = given()
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(data)
                .when().post();
        log.info("Data was posted. Check response.");
        response.then().statusCode(201);
        log.info("Status code was checked.");
        return response;
    }

}

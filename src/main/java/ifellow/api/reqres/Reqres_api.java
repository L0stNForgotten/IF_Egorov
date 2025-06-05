package ifellow.api.reqres;

import io.restassured.path.json.JsonPath;
import java.io.File;

public abstract class Reqres_api {

    public static JsonPath jsonPathGetter(String jsonFile) {
        return JsonPath.from(new File("src/test/resources/" + jsonFile));
    }
}

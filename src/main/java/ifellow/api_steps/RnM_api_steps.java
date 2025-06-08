package ifellow.api_steps;

import ifellow.api.rnm.RnM_api;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class RnM_api_steps extends RnM_api {

    public Map<String, String>[] getRaceAndLocation(JsonPath obj1, JsonPath obj2) {
        JsonPath obj1loc = parserInsideInfo(obj1, "location");
        JsonPath obj2loc = parserInsideInfo(obj2, "location");

        Map<String, String> species = new HashMap<>();
        species.put(obj1.getString("name"), obj1.getString("species"));
        species.put(obj2.getString("name"), obj2.getString("species"));

        Map<String, String> locations = new HashMap<>();
        locations.put(obj1.getString("name"), obj1loc.getString("name"));
        locations.put(obj2.getString("name"), obj2loc.getString("name"));

        log.info("Gotten all needed species and locations.");
        return new Map[]{species, locations};
    }

    public void comparisonOfInfo(Map<String, String>[] infoMassive, JsonPath obj1, JsonPath obj2) {
        String obj1name = obj1.getString("name");
        String obj2name = obj2.getString("name");

        for (Map<String, String> items : infoMassive) {
            String answer = checkEqualsAndNotEquals(items.get(obj1name), items.get(obj2name));
            log.info("Given: {} ({}) and {} ({}).", items.get(obj1name), obj1name, items.get(obj2name), obj2name);
            log.info("{} and {}{}", obj1name, obj2name, answer);
        }
    }
}
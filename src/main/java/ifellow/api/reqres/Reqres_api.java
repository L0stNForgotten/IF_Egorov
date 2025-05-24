package ifellow.api.reqres;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static ifellow.api.ApiConfig.*;
import static ifellow.api.reqres.Reqres_specification.baseRequest;

public abstract class Reqres_api {
    public static final Logger log = LoggerFactory.getLogger(Reqres_api.class);

    @BeforeAll
    public static void init() {
        log.info("Start of test case.");
        log.info("Test requests to {} servers", REQRES_URL.get());
        RestAssured.requestSpecification = baseRequest(
                REQRES_URL.get(),
                REQRES_API_HEADER_KEY.get(),
                REQRES_API_HEADER_VALUE.get());
    }

    @AfterEach
    public void endOfTests() {
        log.info("Test end.");
    }

    @AfterAll
    public static void endOfTestCase() {
        log.info("End of test case.");
    }

    public static JsonPath jsonPathGetter(String jsonFile) {
        return JsonPath.from(new File("src/test/resources/" + jsonFile));
    }
}

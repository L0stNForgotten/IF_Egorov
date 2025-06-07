package ifellow.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import io.restassured.RestAssured;
import ifellow.api.rnm.RnM_specification;

import static ifellow.api.ApiConfig.RNM_URL;

public class RnM_Hook {
    private static final Logger log = LoggerFactory.getLogger(RnM_Hook.class);
    @Before("@rick_n_morty")
    public static void initRNM() {
        log.info("Test requests to {} servers", RNM_URL.get());
        RestAssured.requestSpecification = RnM_specification.baseRequest(RNM_URL.get());
        RestAssured.responseSpecification = RnM_specification.baseResponse(200);
    }
    @AfterAll
    public static void endUp() {
        log.info("End of tests");
    }
}

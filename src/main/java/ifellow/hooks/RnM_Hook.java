package ifellow.hooks;

import ifellow.api.rnm.RnM_specification;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ifellow.api.ApiConfig.RNM_URL;

public class RnM_Hook {
    private static final Logger log = LoggerFactory.getLogger(RnM_Hook.class);

    @Before("@rick_n_morty")
    public static void initRNM() {
        log.info("Test requests to {} servers", RNM_URL.get());
        RestAssured.requestSpecification = RnM_specification.baseRequest(RNM_URL.get());
        RestAssured.responseSpecification = RnM_specification.baseResponse(200);
    }

    @After("@rick_n_morty")
    public static void resetReqres() {
        RestAssured.reset();
    }
}

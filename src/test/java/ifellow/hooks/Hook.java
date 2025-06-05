package ifellow.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.RestAssured;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import ifellow.api.rnm.RnM_specification;
import ifellow.api.reqres.Reqres_specification;
import static ifellow.api.ApiConfig.*;

public class Hook {
    private static final Logger log = LoggerFactory.getLogger(Hook.class);

    @Before("@rick_n_morty")
    public static void initRNM() {
        log.info("Test requests to {} servers", RNM_URL.get());
        RestAssured.requestSpecification = RnM_specification.baseRequest(RNM_URL.get());
        RestAssured.responseSpecification = RnM_specification.baseResponse(200);
    }
}

package ifellow.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import ifellow.api.reqres.Reqres_specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ifellow.api.ApiConfig.*;

public class Reqres_hook {
    public static final Logger log = LoggerFactory.getLogger(Reqres_hook.class);
    @Before("@reqres")
    public static void initREQRES() {
        log.info("Test requests to {} servers", REQRES_URL.get());
        RestAssured.requestSpecification = Reqres_specification.baseRequest(
                REQRES_URL.get(),
                REQRES_API_HEADER_KEY.get(),
                REQRES_API_HEADER_VALUE.get());
    }
}

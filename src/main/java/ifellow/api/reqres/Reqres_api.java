package ifellow.api.reqres;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static ifellow.api.reqres.Reqres_specification.baseRequest;
import static ifellow.api.reqres.Reqres_specification.baseResponse;

public abstract class Reqres_api {

    @BeforeAll
    public static void init() {
        RestAssured.requestSpecification = baseRequest(
                "https://reqres.in/api/",
                "x-api-key",
                "reqres-free-v1");
        RestAssured.responseSpecification = baseResponse(200);
        System.out.println("Start of test case.");
        System.out.println("Test requests to https://reqres.in servers");
    }

    @AfterEach
    public void endOfTests() {
        System.out.println("Test end.\n");
    }

    @AfterAll
    public static void endOfTestCase() {
        System.out.println("End of test case.");
    }
}

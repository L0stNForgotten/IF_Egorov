package ifellow.api.rnm;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RnM_specification {
    public static RequestSpecification baseRequest(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .build();
    }

    public static ResponseSpecification baseResponse(Integer statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}

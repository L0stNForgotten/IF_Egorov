package ifellow;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;

import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;

public class Specification {
    public static RequestSpecification baseRequest (String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .build();
    }

    public static ResponseSpecification baseResponse (Integer statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}
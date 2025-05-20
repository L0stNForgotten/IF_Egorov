package ifellow.api.reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reqres_specification {

        public static RequestSpecification baseRequest(String uri, String key, String value) {
            return new RequestSpecBuilder()
                    .setBaseUri(uri)
                    .addHeader(key, value)
                    .build();
        }

        public static ResponseSpecification baseResponse(Integer statusCode) {
            return new ResponseSpecBuilder()
                    .expectStatusCode(statusCode)
                    .build();
        }
}


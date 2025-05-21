package ifellow.api.reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Reqres_specification {

    public static RequestSpecification baseRequest(String uri, String key, String value) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .addHeader(key, value)
                .build();
    }
}


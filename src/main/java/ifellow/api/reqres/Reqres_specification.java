package ifellow.api.reqres;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Reqres_specification {

    public static RequestSpecification baseRequest(String uri, String h_key, String h_value) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .addHeader(h_key, h_value)
                .build();
    }
}
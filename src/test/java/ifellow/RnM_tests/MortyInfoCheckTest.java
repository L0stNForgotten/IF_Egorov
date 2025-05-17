package ifellow.RnM_tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MortyInfoCheckTest {
    @Test
    public void last_episode () {
        String episode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when().get("/character/2")
                .then()
                .assertThat().statusCode(200)
                .body("name", Matchers.is("Morty Smith"))
                .extract().path("episode[-1]");
        System.out.println(episode + " - последний эпизод, где встречался Морти Смит"); // <- Сервер не обновлялся с 3 квартала 2021 года, поэтому информация данного сайта может быть не действительна.
    }
}

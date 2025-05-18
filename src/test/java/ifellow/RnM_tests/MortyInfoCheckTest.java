package ifellow.RnM_tests;

import java.util.Map;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ifellow.Specification.*;
import static io.restassured.RestAssured.given;

public class MortyInfoCheckTest {
    @BeforeAll
    public static void innit () {
        RestAssured.requestSpecification = baseRequest("https://rickandmortyapi.com/api");
        RestAssured.responseSpecification = baseResponse(200);
    }

    private Map<String, Object>[] charEpisodeInfo (Integer id, String nameToCheck, String episode) {
        Map <String, Object> character = given()
                .when().get("/character/"+id)
                .then()
                .body("name", Matchers.is(nameToCheck))
                .extract().path("");

        Map <String, Object> charsEpisode = given().spec(baseRequest((String) character.get(episode)))
                .when().get()
                .then().extract().path("");

        return (Map<String, Object>[]) new Map[] {character, charsEpisode};
    }

    @DisplayName("Запрос на поиск, где встречался последний раз персонаж")
    @Test
    public void MortyTest () {
        Map<String, Object> [] charInfo = charEpisodeInfo(2, "Morty Smith","episode[-1]"); // <- 0 - персонаж; 1 - епизод, который был указан
        Map<String, Object> [] charInfo1 = charEpisodeInfo(1, "Rick Sunchez","episode[-1]");
    }
}

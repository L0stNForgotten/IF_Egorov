package ifellow.RnM_tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ifellow.Specification.*;
import static io.restassured.RestAssured.given;

public class MortyInfoCheckTest {
    @BeforeAll
    public static void init () {
        RestAssured.requestSpecification = baseRequest("https://rickandmortyapi.com/api");
        RestAssured.responseSpecification = baseResponse(200);
        System.out.println("Test requests to rickandmortyapi.com servers");
    }

    // Solo returns
    private Map<String, Object> info_Character (String filter, String nameToCheck) {
        return given().when().get("/character/"+filter)
                .then()
                .body("name", Matchers.is(nameToCheck))
                .extract().path("");
    }

    private Map<String, Object> info_Episode (String filter, String nameToCheck) {
        return given().when().get("/episode/"+filter)
                .then()
                .body("name", Matchers.is(nameToCheck))
                .extract().path("");
    }

    private  Map<String, Object> info_Location (String filter, String nameToCheck) {
        return given().when().get("/location/"+filter)
                .then()
                .body("name", Matchers.is(nameToCheck))
                .extract().path("");
    }

    // Duo returns
    // From character info + 2
    private Map<String, Map<String, Object>>  info_CharEpisode(String filter, String nameToCheck, Integer episode_request) {
        final Map<String, Object> character =  info_Character(filter, nameToCheck);

        @SuppressWarnings("unchecked")
        List<String> episodeUrls = (List<String>) character.get("episode");
        if (episode_request < 0) { episode_request = episodeUrls.size() + episode_request; }

        final Map<String, Object> episode = given()
                .spec(baseRequest(episodeUrls.get(episode_request)))
                .when().get()
                .then().extract().path("");

        return Map.of(
                "character", character,
                "episode", episode
        );
    }

    private Map<String, Map<String, Object>> info_CharLocation(String filter, String nameToCheck){
        final Map<String, Object> character = info_Character(filter, nameToCheck);

        @SuppressWarnings("unchecked")
        final Map<String, Object> location_data = (Map<String, Object>) character.get("location");

        final Map<String, Object> location = given()
                .spec(baseRequest((String) location_data.get("url")))
                .when().get()
                .then().extract().path("");

        return Map.of(
                "character", character,
                "location", location
        );
    }

    // From episode info
    private Map<String, Map<String, Object>>  info_EpChar(String filter, String nameToCheck, int character_request) {
        final Map<String, Object> episode =  info_Episode(filter, nameToCheck);

        @SuppressWarnings("unchecked")
        List<String> characterUrls = (List<String>) episode.get("character");
        if (character_request < 0) { character_request = characterUrls.size() + character_request; } else if (character_request >= 0) { character_request += 1; }

        final Map<String, Object> character = given()
                .spec(baseRequest(characterUrls.get(character_request)))
                .when().get()
                .then().extract().path("");

        return Map.of(
                "episode", episode,
                "character", character
        );
    }

    private Object test (Map<String, Object> subject, String key, Integer object_id) {
        Map<String, Object> outObj = new HashMap<>();
        if (subject.get(key) instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, String> type_map = (Map<String, String>) subject.get(key);
            outObj =  given().spec(baseRequest(type_map.get("url")))
                    .when().get()
                    .then().extract().path("");

        } else if (subject.get(key) instanceof List) {

            @SuppressWarnings("unchecked")
            List<String> urls_list = (List<String>) subject.get(key);
            if (object_id < 0) { object_id = urls_list.size() + object_id; }

            outObj = given().spec(baseRequest(urls_list.get(object_id)))
                    .when().get()
                    .then().extract().path("");
        }
        return outObj;
    }

    // From location info


    @DisplayName("Request: Morty's last episode")
    @Test
    public void Morty_CharEpisodeInfoTest () {
//        final Map<String, Map<String, Object>> MortyInfo = info_CharEpisode("2", "Morty Smith",-1);
//        final String chr = "character";
//        final String ep = "episode";

        final Map<String, Object> Morty = info_Character("2","Morty Smith");
        final Map<String, Object> Episode = test(Morty, "episode", 1);


        System.out.println("\nThe last episode where " + Morty.get("name") + " was shown is " + MortyInfo.get(ep).get("episode"));
        System.out.println("Morty's URL: " + Morty.get("url"));
        System.out.println("Episode URL: " + MortyInfo.get(ep).get("url"));
    }
}

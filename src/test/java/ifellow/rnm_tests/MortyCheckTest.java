package ifellow.rnm_tests;

import ifellow.rnm_proprieties.TestProprieties;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import java.util.Map;

import static ifellow.Specification.baseRequest;
import static ifellow.Specification.baseResponse;

public class MortyCheckTest extends TestProprieties {

    @BeforeAll
    public static void init() {
        RestAssured.requestSpecification = baseRequest("https://rickandmortyapi.com/api");
        System.out.println("Start of test case.");
        System.out.println("Test requests to https://rickandmortyapi.com servers");
    }

    @AfterEach
    public void endOfTests() {
        System.out.println("\nTest end.");
    }

    @AfterAll
    public static void endOfTestCase() {
        System.out.println("\nEnd of test case.");
    }

    @DisplayName("Request: Morty's last episode")
    @Test
    public void getMortyCharEpisodeInfoTest() {
        RestAssured.responseSpecification = baseResponse(200);
        final Map<String, Object> morty = infoObject("/character/2", "Morty Smith");
        final Map<String, Object> episode = parserInsideInfo(morty, "episode");
        System.out.println("\nThe last episode where " + morty.get("name") + " was shown is " + episode.get("episode") + " (" + episode.get("name") + ").");
        System.out.println(morty.get("name") + "'s URL: " + morty.get("url") + ".");
        System.out.println("Episode URL: " + episode.get("url") + ".");
    }

    @DisplayName("Request: Last episode person")
    @Test
    public void getLastPersonEpisode() {
        getMortyCharEpisodeInfoTest();
        RestAssured.responseSpecification = baseResponse(200);
        final Map<String, Object> morty = infoObject("/character/2", "Morty Smith");
        final Map<String, Object> episode = parserInsideInfo(morty, "episode");
        final Map<String, Object> lastPerson = parserInsideInfo(episode, "characters");
        System.out.println("\nThe last person in episode \"" + episode.get("name") + "\" is " + lastPerson.get("name") + ".");
        System.out.println(lastPerson.get("name") + "'s URL: " + lastPerson.get("url") + ".");
    }

    @DisplayName("Request: Last episode person's location")
    @Test
    public void getLocation() {
        getLastPersonEpisode();
        RestAssured.responseSpecification = baseResponse(200);
        final Map<String, Object> morty = infoObject("/character/2", "Morty Smith");
        final Map<String, Object> episode = parserInsideInfo(morty, "episode");
        final Map<String, Object> lastPerson = parserInsideInfo(episode, "characters");
        final Map<String, Object> lastPersonLocation = parserInsideInfo(lastPerson, "location");
        System.out.println("\n" + lastPerson.get("name") + "'s location is " + lastPersonLocation.get("name") + ".");
        System.out.println(lastPerson.get("name") + "'s URL: " + lastPersonLocation.get("url") + ".");
    }

    @DisplayName("Comparison: Location and race comparison of Morty and Last Person")
    @Test
    public void comparisonLocationAndRace() {
        getLocation();
        RestAssured.responseSpecification = baseResponse(200);
        final Map<String, Object> morty = infoObject("/character/2", "Morty Smith");
        final Map<String, Object> mortyLocation = parserInsideInfo(morty, "location");
        final Map<String, Object> episode = parserInsideInfo(morty, "episode");
        final Map<String, Object> lastPerson = parserInsideInfo(episode, "characters");
        final Map<String, Object> lastPersonLocation = parserInsideInfo(lastPerson, "location");
        System.out.println("\n" + morty.get("name") + "'s and " + lastPerson.get("name") + "'s locations" + checkEqualsAndNotEquals(mortyLocation, lastPersonLocation, "name"));
        System.out.println("\n" + morty.get("name") + "'s and " + lastPerson.get("name") + "'s races" + checkEqualsAndNotEquals((String) lastPerson.get("species"), (String) morty.get("species")));

    }
}

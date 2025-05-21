package ifellow.steps.rnm;

import ifellow.api.rnm.RnM_api;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class RnM_steps extends RnM_api {

    private final JsonPath morty = infoObject("/character/2", "status", "Alive");
    private final JsonPath episode = parserInsideInfo(morty, "episode");
    private final JsonPath lastPerson = parserInsideInfo(episode, "characters");
    private final JsonPath mLocation = parserInsideInfo(morty, "location");
    private final JsonPath lpLocation = parserInsideInfo(lastPerson, "location");

    public void checkMortyName() {
        String name = morty.getString("name");
        Assertions.assertTrue(name.equalsIgnoreCase("Morty Smith"));
        System.out.println("Person \"" + name + "\" was found.");
    }

    public void getMortyLastEpisodeTest() {
        String episodeCode = episode.getString("episode");
        Assertions.assertTrue(episodeCode.equalsIgnoreCase("S05E10"));
        System.out.println("Episode \"" + episode.getString("name") + "\" was found.");
    }

    public void getLastEpisodePerson() {
        String name = lastPerson.getString("name");
        Assertions.assertTrue(name.equalsIgnoreCase("Young Jerry"));
        System.out.println("Episode's last person \"" + name + "\" was found.");
    }

    public void lepGetLocation() {
        String locationName = lpLocation.getString("name");
        Assertions.assertTrue(locationName.equalsIgnoreCase("Earth (Unknown dimension)"));
        System.out.println("Location of " + lastPerson.getString("name") + " - " + locationName);
    }

    public Map<String, String>[] getRaceAndLocation() {
        Map<String, String> species = new HashMap<>();
        species.put(morty.getString("name"), morty.getString("species"));
        species.put(lastPerson.getString("name"), lastPerson.getString("species"));

        Map<String, String> locations = new HashMap<>();
        locations.put(morty.getString("name"), mLocation.getString("name"));
        locations.put(lastPerson.getString("name"), lpLocation.getString("name"));

        System.out.println("Gotten all needed species and locations.");
        return new Map[]{species, locations};
    }

    public void comparisonOfInfo(Map<String, String>[] infoMassive) {
        for (Map<String, String> items : infoMassive) {
            String mortyName = morty.getString("name");
            String lastPersonName = lastPerson.getString("name");
            String answer = checkEqualsAndNotEquals(items.get(mortyName), items.get(lastPersonName));
            System.out.println("Given: " + items.get(mortyName) + " (" + mortyName + ") and " + items.get(lastPersonName) + " (" + lastPersonName + ").");
            System.out.println(mortyName + " and " + lastPersonName + answer);
        }
    }
}
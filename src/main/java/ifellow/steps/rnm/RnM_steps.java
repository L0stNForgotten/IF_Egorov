package ifellow.steps.rnm;

import java.util.Map;

import ifellow.api.rnm.RnM_api;
import org.junit.jupiter.api.Assertions;

public class RnM_steps extends RnM_api {
    private final Map<String, Object> morty = infoObject("/character/2", "status", "Alive");
    private final Map<String, Object> episode = parserInsideInfo(morty, "episode");
    private final Map<String, Object> lastPerson = parserInsideInfo(episode, "characters");

    private final Map<String, Object> mLocation = parserInsideInfo(morty, "location");
    private final Map<String, Object> lpLocation = parserInsideInfo(lastPerson, "location");

    public void checkMortyName() {
        String mName = (String) morty.get("name");
        Assertions.assertTrue(mName.equalsIgnoreCase("Morty Smith"));
        System.out.println("Person \"" + morty.get("name") + "\" was found.");
    }

    public void getMortyLastEpisodeTest () {
        String mEpisode = (String) episode.get("episode");
        Assertions.assertTrue(mEpisode.equalsIgnoreCase("S05E10"));
        System.out.println("Episode \"" + episode.get("name") + "\" was found.");
    }

    public void getLastEpisodePerson() {
        String eLastPersonName = (String) lastPerson.get("name");
        Assertions.assertTrue(eLastPersonName.equalsIgnoreCase("Young Jerry"));
        System.out.println("Episode's last person \"" + lastPerson.get("name") + "\" was found.");
    }

    public void lepGetLocation() {
        String location = (String) lpLocation.get("name");
        Assertions.assertTrue(location.equalsIgnoreCase("Earth (Unknown dimension)"));
        System.out.println("Location of " + lastPerson.get("name") + " - " + location);
    }

    public Map<String, String> [] getRaceAndLocation() {
        Map<String, String> species = Map.of(
                (String) morty.get("name"), (String) morty.get("species"),
                (String) lastPerson.get("name"), (String) lastPerson.get("species")
        );

        Map<String, String> location = Map.of(
                (String) morty.get("name"), (String) mLocation.get("name"),
                (String) lastPerson.get("name"), (String) lpLocation.get("name")
        );
        System.out.println("Gotten all needed species and locations.");
        return new Map [] {species, location};
    }

    public void comparisonOfInfo (Map <String, String> [] infoMassive){
        for (Map <String, String> items : infoMassive) {
            String answer = checkEqualsAndNotEquals(items.get((String) morty.get("name")), items.get((String) lastPerson.get("name")));
            System.out.println("Given: " + items.get((String) morty.get("name")) + " (" + morty.get("name") + ") and " + items.get((String) lastPerson.get("name"))+ " (" + lastPerson.get("name") + ").");
            System.out.println(morty.get("name")+ " and " + lastPerson.get("name") + answer);
        }
    }
}

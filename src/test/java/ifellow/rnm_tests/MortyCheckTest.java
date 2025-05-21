package ifellow.rnm_tests;

import ifellow.steps.rnm.RnM_steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MortyCheckTest extends RnM_steps {
    final private RnM_steps steps = new RnM_steps();

    @DisplayName("Request: Morty's last episode")
    @Test
    public void getMortyCharEpisodeInfoTest() {
        steps.checkMortyName();
        steps.getMortyLastEpisodeTest();
    }

    @DisplayName("Request: Last episode person")
    @Test
    public void getLastPersonEpisode() {
        getMortyCharEpisodeInfoTest();
        steps.getLastEpisodePerson();
    }

    @DisplayName("Request: Last episode person's location")
    @Test
    public void getLocation() {
        getLastPersonEpisode();
        steps.lepGetLocation();
    }

    @DisplayName("Comparison: Location and race comparison of Morty and Last Person")
    @Test
    public void comparisonLocationAndRace() {
        getLocation();
        comparisonOfInfo(getRaceAndLocation());
    }
}

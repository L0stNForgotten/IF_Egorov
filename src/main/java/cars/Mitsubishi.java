package cars;

public class Mitsubishi extends Car {
    public Mitsubishi(String inpModel, int inpYear, String inpEngine, Float inpWeight, String inpColor) {
        super("Mitsubishi", inpModel, inpEngine, inpWeight, inpColor, inpYear);
    }

    public void Wiki() {
        HTML_Parser wiki = new HTML_Parser();
        wiki.WikiParser("https://ru.wikipedia.org/wiki/Mitsubishi");
    }
}
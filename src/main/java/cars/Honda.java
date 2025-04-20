package cars;

public class Honda extends Car {
    public Honda(String inpModel, int inpYear, String inpEngine, Float inpWeight, String inpColor) {
        super("Honda", inpModel, inpEngine, inpWeight, inpColor, inpYear);
    }

    public void Wiki() {
        HTML_Parser wiki = new HTML_Parser();
        wiki.WikiParser("https://ru.wikipedia.org/wiki/Honda");
    }
}
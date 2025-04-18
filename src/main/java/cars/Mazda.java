package cars;
public class Mazda extends Car {
    public Mazda(String inpModel, int inpYear , String inpEngine, Float inpWeight, String inpColor) {
        super("Mazda", inpModel, inpEngine, inpWeight, inpColor, inpYear);
    }
    public void Wiki(){
        HTML_Parser wiki = new HTML_Parser();
        wiki.WikiParser("https://ru.wikipedia.org/wiki/Mazda");
    }
}
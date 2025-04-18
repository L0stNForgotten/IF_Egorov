package cars;
public class Nissan extends Car {
    public Nissan(String inpModel, int inpYear , String inpEngine, Float inpWeight, String inpColor) {
        super("Nissan", inpModel, inpEngine, inpWeight, inpColor, inpYear);
    }
    public void Wiki(){
        HTML_Parser wiki = new HTML_Parser();
        wiki.WikiParser("https://ru.wikipedia.org/wiki/Nissan");
    }
}
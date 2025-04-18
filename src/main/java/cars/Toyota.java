package cars;
public class Toyota extends Car {
    public Toyota(String inpModel, int inpYear , String inpEngine, Float inpWeight, String inpColor) {
        super("Toyota", inpModel, inpEngine, inpWeight, inpColor, inpYear);
    }
    public void Wiki(){
        HTML_Parser wiki = new HTML_Parser();
        wiki.WikiParser("https://ru.wikipedia.org/wiki/Toyota");
    }
}
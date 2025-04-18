package cars;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.*;
public class HTML_Parser {
    public void WikiParser(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements element = Objects.requireNonNull(document.selectFirst("#mw-content-text .mw-parser-output")).select("p");
            System.out.println(element.text());
        } catch (Exception e){
            System.err.println("Unexpected error: " + e.getClass().getSimpleName());
        }
    }
}
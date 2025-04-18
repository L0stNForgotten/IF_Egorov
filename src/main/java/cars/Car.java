package cars;
import lombok.Data;
@Data
public abstract class Car {
    private final String name;
    private final String model;
    private final String engine;
    private String color;
    private final Float weight;
    private final int year;
    public Car(String name, String model, String engine, Float weight,
               String color, int year) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
}
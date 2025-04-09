package cars;
import lombok.*;

public abstract class Car {
    @Getter
    private final int year;
    private final String name, model, engine, weight;
    @Setter
    private String color = "белый";

    public Car(String inpName, String inpModel, String inpEngine, String inpWeight,
               String inpColor, int inpYear){
        this.name = inpName;
        this.model = inpModel;
        this.year = inpYear;
        this.engine = inpEngine;
        this.weight = inpWeight;
        this.color = inpColor;
    }

    public void getInfo (){
        System.out.println(name + " " + model + " " + year + " года. Двигатель - " + engine + ". Вес машины - "
                + weight + " тонн. Цвет машины - " + color + ".");
    }
}
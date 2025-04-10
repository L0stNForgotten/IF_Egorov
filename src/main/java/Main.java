import cars.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //it's Main origin

        Honda car1 = new Honda(
                "CR-Z Mugen",
                2012,
                "LDA-MF6 1.5L i-VTEC",
                1.24f,
                "красный");

        Mazda car2 = new Mazda(
                "Luce LA4",
                1979,
                "2-роторый Wankel 13B",
                1.4f,
                "зелёный"
        );

        Mitsubishi car3 = new Mitsubishi(
                "Pajero II",
                1991,
                "4M40 2.8L турбодизель",
                1.85f,
                "красный"
        );

        Nissan car4 = new Nissan(
                "Skyline R32 GTR",
                1989,
                "RB26DETT 2.6L twin-turbo",
                1.43f,
                "синий"
        );

        Toyota car5 = new Toyota(
                "GR Yaris",
                2021,
                "G16E-GTS 1.6L turbo (272 л.с.)",
                1.28f,
                "голубой"
        );

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        CarFunctions do_ = new CarFunctions();
        System.out.println("-".repeat(20));
        System.out.println("Автопарк");
        for (Car car : cars)
            do_.fullInfo(car);
        System.out.println("-".repeat(20));

//      Цикл
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println("Начало цикла для " + car.getName() + " " + car.getModel() + ".");
            do_.checkCarAge(car);
            do_.colorChanger(car);
            System.out.println("Конец цикла для " + car.getName() + " " + car.getModel() + ".");
            if (i < cars.size() - 1)
                System.out.println("Начинаю новый цикл.");
            else
                System.out.println("Конец всех циклов");
            System.out.println("-".repeat(20));
        }

//        do_.fullInfo(car1);
    }
}
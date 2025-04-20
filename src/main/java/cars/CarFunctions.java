package cars;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.reflect.Method;

public class CarFunctions {
    public void fullInfo(Car car) {
        System.out.println(car.getName() + " " + car.getModel() + " " + car.getYear() + " года. Двигатель - " + car.getEngine()
                + ". Вес машины - " + car.getWeight() + " тонны. Цвет машины - " + car.getColor() + ".");
    }

    public void checkCarAge(Car car) {
        if (car.getYear() > 2006) {
            System.out.println("Машина выпущена после 2006 года.");
            fullInfo(car);
        } else
            System.out.println(car.getName() + " " + car.getModel() + ": Устаревшее авто.");
    }

    public void colorChanger(Car car, String colorToFind, String colorToChange) {
        if (car.getColor().equalsIgnoreCase(colorToFind)) {
            car.setColor(colorToChange);
            System.out.println(car.getName() + " " + car.getModel() + ": Цвет изменён.");
            fullInfo(car);
        } else if (car.getColor().equalsIgnoreCase(colorToChange))
            System.out.println(car.getName() + " " + car.getModel() + ": Цвет машины совпадает с " + colorToChange + ". Перекраска запрещена.");
        else
            System.out.println(car.getName() + " " + car.getModel() + ": Цвет машины не совпадает с " + colorToFind + ". Перекраска запрещена.");
    }

    public void race(List<Car> list) {
        Random randomSpeedChanger = new Random();
        Map<Integer, Object> speedMap = new TreeMap<>(Comparator.reverseOrder());
        for (Car car : list) {
            int speed;
            float changer = randomSpeedChanger.nextFloat() + randomSpeedChanger.nextInt(1) + 0.55f;
            if (changer != 0)
                speed = (int) ((225 / car.getWeight() * changer) * 1.25);
            else speed = (int) ((225 / car.getWeight()) * 1.25);
            speedMap.put(speed, car);
        }
        System.out.println("Таблица лидеров: ");
        AtomicInteger i = new AtomicInteger();
        speedMap.forEach((speed, value) -> {
            Car car = (Car) value;
            i.getAndIncrement();
            System.out.println(i + " место: " + car.getName() + " " + car.getModel() + " (" + speed + " км/ч)");
        });
    }

    public void getWikiOutForAll(List<Car> list) {
        for (Car car : list) {
            try {
                Method method = car.getClass().getMethod("Wiki");
                method.invoke(car);
            } catch (Exception e) {
                System.err.println("Метод Wiki не поддерживается.");
            }
        }
    }
}
package cars;

public class CarFunctions {

    public void fullInfo(Car car){
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

    public void colorChanger(Car car){
        if (car.getColor().equalsIgnoreCase("красный")) {
            car.setColor("зелёный");
            System.out.println(car.getName() + " " + car.getModel() + ": Цвет изменён");
            fullInfo(car);
        } else {
            System.out.println(car.getName() + " " + car.getModel() + ": Цвет машины не красный. Перекраска запрещена.");
        }
    }
}

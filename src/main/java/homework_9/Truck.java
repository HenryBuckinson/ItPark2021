package homework_9;

public class Truck extends Automobile {
    private String model;

    Truck(String model) {
        this.model = model;
    }

    @Override
    public final void move(int distance) {
        if (distance > 1200) {
            System.out.println("Грузовой автомобиль " + model + " не проедет на одном баке дистанцию в " + distance + " км.");
        } else {
            System.out.println("Грузовой автомобиль " + model + " проедет на одном баке дистанцию в " + distance + " км.");
        }
    }
}

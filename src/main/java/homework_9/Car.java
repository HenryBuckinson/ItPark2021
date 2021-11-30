package homework_9;

public class Car extends Automobile {
    private String model;

    Car(String model) {
        this.model = model;
    }

    @Override
    public final void move(int distance) {
        if (distance > 500) {
            System.out.println("Легковой автомобиль " + model + " не проедет на одном баке дистанцию в " + distance + " км.");
        } else {
            System.out.println("Легковой автомобиль " + model + " проедет на одмом баке дистанцию в " + distance + " км.");
        }
    }
}

package homework_11;

import homework_11.Automobiles.Car;
import homework_11.Automobiles.Truck;
import homework_11.Checkpoint.Checkpoint;

public class MainProgram {
    public static void main(String[] args) {
        Truck truck = new Truck(7.8, 6.2, 3.8, 2.2);//без прицепа
        Car car = new Car(1.5, 4.2, 1.2, 1.6);

        truck.speed(60);
        car.speed(75);

        Checkpoint borderPost = new Checkpoint();

        borderPost.passPost(truck);
        borderPost.passPost(car);

    }
}

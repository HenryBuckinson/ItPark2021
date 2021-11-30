package homework_9;

import java.util.Random;

public class MainProgram {
    public static void main(String[] args) {
        Random rnd = new Random();
        Automobile[] vehicles = new Automobile[]{
                new Car("Mustang"),
                new Truck("Scania"),
                new Car("Renault"),
                new Truck("MAN"),
                new Truck("Kamaz"),
                new Car("Volkswagen"),
                new Car("Bugatti"),
                new Truck("DAF"),
                new Truck("MAZ"),
                new Car("BMW")
        };
        System.out.println("Сводка автопарка: ");
        for (Automobile cars : vehicles) {
            cars.move(rnd.nextInt(1500));
        }
    }
}

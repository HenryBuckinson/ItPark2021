package homework_11.Checkpoint;

import homework_11.Automobiles.Car;
import homework_11.Automobiles.Truck;

public class Checkpoint {

    public Checkpoint() {
    }

    /**
     * @param car Объект типа Car.
     *            Метод отображает информацию о разрешении или запрете для легкового автомобиля при проезде на КПП.
     */
    public void passPost(Car car) {
        if (car.isFireExtinguisher()) {
            System.out.println("Автомобилю " + car.getCarName() + " с регистрационным номером "
                    + car.getRegistrationNumber() + " проезд через КПП разрешен.");
        } else {
            throw new IllegalArgumentException("У автомобиля " + car.getCarName() + " с регистрационным номером "
                    + car.getRegistrationNumber() + " отсутствует огнетушитель. Проезд" +
                    " через КПП запрещен.");
        }
    }

    /**
     * @param truck Объект типа Truck.
     *              Метод отображает информацию о разрешении или запрете для грузового автомобиля при проезде на КПП.
     */
    public void passPost(Truck truck) {
        if (truck.getHeight() > TruckConditions.MAX_PERMISSION_HEIGHT.getValue()) {
            throw new IllegalArgumentException("Грузовому автомобилю " + truck.getCarName() + " с регистрационным номером "
                    + truck.getRegistrationNumber() + " не соответствует требованиям по высоте. Проезд" +
                    " через КПП запрещен.");
        }
        if (truck.getWidth() > TruckConditions.MAX_PERMISSION_WIDTH.getValue()) {
            throw new IllegalArgumentException("Грузовому автомобилю " + truck.getCarName() + " с регистрационным номером "
                    + truck.getRegistrationNumber() + " не соответствует требованиям по ширине. Проезд" +
                    " через КПП запрещен.");
        }
        if (truck.getWeight() > TruckConditions.MAX_PERMISSION_WEIGHT.getValue()) {
            throw new IllegalArgumentException("Грузовому автомобилю " + truck.getCarName() + " с регистрационным номером "
                    + truck.getRegistrationNumber() + " не соответствует требованиям по массе. Проезд" +
                    " через КПП запрещен.");
        } else {
            System.out.println("Грузовому автомобилю " + truck.getCarName() + " с регистрационным номером "
                    + truck.getRegistrationNumber() + " проезд через КПП разрешен.");
        }
    }
}

package homework_11.Automobiles;

import homework_11.AutoEnums.Trucks;

import java.util.Random;

public class Truck extends Automobile {

    /**
     * @param weight масса в тоннах.
     * @param length длина в метрах.
     * @param height высота в метрах.
     * @param width ширина в метрах.
     */
    public Truck(double weight, double length, double height, double width) {
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        if (weight <= 0 | length <= 0 | height <= 0 | width <= 0) {
            throw new ArithmeticException("Аргументы конструктора не должны быть меньше или равны нулю!");
        }
        randomTruck();
        randomRegistrationNumber();
    }

    /**
     * Метод случайным образом формирует регистрационный номер грузового автомобиля.
     */
    private void randomRegistrationNumber() {
        Random randomRegisNumber = new Random();
        this.registrationNumber = randomRegisNumber.nextInt(501);//Грузовые авто имеют номера от 0 до 500
        System.out.println("Был создан грузовой автомобиль: " + carName);
    }

    /**
     * Метод извлекает случайное имя легкового автомобиля из перечисления Cars, которое присваивается объекту класса Car.
     */
    private void randomTruck() {
        Trucks[] values = Trucks.values();
        Random modelTruck = new Random();
        int numberFromTrucks = modelTruck.nextInt(0, values.length);
        this.carName = values[numberFromTrucks].getModel();
    }

    @Override
    public void speed(int velocity) {
        if (velocity <= 0) {
            throw new IllegalArgumentException("Скорость не должна быть отрицательной.");
        }
        if (velocity > 80 & velocity < 100) {
            throw new IllegalArgumentException("Скорость движения не должна превышать 80 км/ч.");
        } else if (velocity > 100) {
            throw new IllegalArgumentException("Скорость в " + velocity +
                    " км/ч превышает установленные законном рамки. Нарушитель с регистрационным номером №"
                    + registrationNumber + " будет задержан " +
                    "представителем власти.");
        }
        System.out.println(this.carName + " движется со скоростью " + velocity + " км/ч.");
    }
}

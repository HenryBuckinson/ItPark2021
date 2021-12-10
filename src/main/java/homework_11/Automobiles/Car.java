package homework_11.Automobiles;

import homework_11.AutoEnums.Cars;

import java.util.Random;

public class Car extends Automobile {

    private final boolean fireExtinguisher;

    /**
     * @param weight масса в тоннах.
     * @param length длина в метрах.
     * @param height высота в метрах.
     * @param width ширина в метрах.
     */
    public Car(double weight, double length, double height, double width) {
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        if (weight <= 0 | length <= 0 | height <= 0 | width <= 0) {
            throw new ArithmeticException("Аргументы конструктора не должны быть меньше или равны нулю!");
        }
        randomCar();
        randomRegistrationNumber();
        fireExtinguisher = isExtinguisher();
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

    public boolean isFireExtinguisher() {
        return fireExtinguisher;
    }

    /**
     * Метод случайным образом формирует регистрационный номер легкового автомобиля.
     */
    private void randomRegistrationNumber() {
        Random randomRegisNumber = new Random();
        this.registrationNumber = randomRegisNumber.nextInt(501, 1001);//Легковые авто имеют номера от 500 до 1000
        System.out.println("Был создан легковой автомобиль: " + carName);
    }

    /**
     * Метод извлекает случайное имя легкового автомобиля из перечисления Cars, которое присваивается объекту класса Car.
     */
    private void randomCar() {
        Cars[] values = Cars.values();
        Random modelTruck = new Random();
        int numberFromTrucks = modelTruck.nextInt(0, values.length);
        this.carName = values[numberFromTrucks].getModel();
    }

    /**
     * @return Метод случайным образом возвращает логическое значение, которое определяет наличие огнетушителя
     * в легковом автомобиле.
     */
    private boolean isExtinguisher() {
        final boolean fireExtinguisher;
        Random zeroOrOne = new Random();
        int item = zeroOrOne.nextInt(2);
        fireExtinguisher = item != 0;
        return fireExtinguisher;
    }


}

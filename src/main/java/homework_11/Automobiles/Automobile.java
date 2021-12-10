package homework_11.Automobiles;

public abstract class Automobile {

    protected int registrationNumber;
    protected int velocity = 0;
    protected double weight;
    protected double length, height, width;
    protected String carName;


    /**
     * @param velocity скорость в км/ч.
     *                 Метод задаёт скорость движения для объектов Car и Truck.
     */
    public abstract void speed(int velocity);

    public String getCarName() {
        return carName;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public double getWeight() {
        return weight;
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}

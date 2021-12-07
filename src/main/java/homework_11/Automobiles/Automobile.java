package homework_11.Automobiles;

public abstract class Automobile {

    protected int registrationNumber;
    protected int velocity = 0;
    protected double weight;
    protected double length, height, width;
    protected String carName;

    public String getCarName() {
        return carName;
    }

    public abstract void speed(int velocity);

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}

package homework_10;

public enum TemperatureCoefficients {
    ABSOLUTE_ZERO(-273.15);// по отношению к градусу Цельсия

    private double value;

    TemperatureCoefficients(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

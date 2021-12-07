package homework_10;

public enum TemperatureCoefficients {
    ABSOLUTE_ZERO(-273.15),// по отношению к градусу Цельсия
    ZERO_СELSIUS_IN_FAHRENHEIT(32),//0 градусов цельсия в Фаренгейтах
    FORWARD_MULTIPLIER(5 / 9),//Прямой постоянный множитель
    BACKWARD_MULTIPLIER(9 / 5);//Обратный постоянный множитель

    private double value;

    TemperatureCoefficients(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

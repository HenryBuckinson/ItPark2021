package homework_10;

public record Temperature(double temperatureValue, char unitOfValue) implements Converter {

    public Temperature(double temperatureValue, char unitOfValue) {
        this.temperatureValue = temperatureValue;
        if (unitOfValue == 'C' | unitOfValue == 'F' | unitOfValue == 'K') {
            this.unitOfValue = unitOfValue;
        } else {
            this.unitOfValue = 'C';
        }
    }

    public void displayTemperature() {
        System.out.println("Информация о температуре объекта: " + temperatureValue + " " + unitOfValue);
    }


    @Override
    public Temperature convertToFahrenheit() {
        System.out.println("Процесс конвертирования в градус Фаренгейта...");
        double newValue = 0;
        char newMeasure = 'C';
        double tempConst = Math.abs(TemperatureCoefficients.ABSOLUTE_ZERO.getValue());
        if (unitOfValue == 'F') {
            return new Temperature(temperatureValue, unitOfValue);
        } else {
            if (unitOfValue == 'C') {
                newValue = (temperatureValue * 9 / 5) + 32;
                newMeasure = 'F';
            }
            if (unitOfValue == 'K') {
                newValue = (temperatureValue - tempConst) * 9 / 5 + 32;
                newMeasure = 'F';
            }
        }
        return new Temperature(newValue, newMeasure);
    }

    @Override
    public Temperature convertToCalvin() {
        double newValue = 0;
        char newMeasure = 'C';
        double tempConst = Math.abs(TemperatureCoefficients.ABSOLUTE_ZERO.getValue());
        System.out.println("Процесс конвертирования в Кельвин...");
        if (unitOfValue == 'K') {
            return new Temperature(temperatureValue, unitOfValue);
        } else {
            if (unitOfValue == 'C') {
                newValue = temperatureValue + tempConst;
                newMeasure = 'K';
            }
            if (unitOfValue == 'F') {
                newValue = (temperatureValue - 32) * 5 / 9 + 273.15;
                newMeasure = 'K';
            }
        }
        return new Temperature(newValue, newMeasure);
    }

    @Override
    public Temperature convertToСelsius() {
        double newValue = 0;
        char newMeasure = 'C';
        double tempConst = Math.abs(TemperatureCoefficients.ABSOLUTE_ZERO.getValue());
        System.out.println("Процесс конвертирования в градус Цельсия...");
        if (unitOfValue == 'C') {
            return new Temperature(temperatureValue, unitOfValue);
        } else {
            if (unitOfValue == 'K') {
                newValue = temperatureValue - tempConst;
                newMeasure = 'C';
            }
            if (unitOfValue == 'F') {
                newValue = (temperatureValue - 32) * 5 / 9;
                newMeasure = 'C';
            }
        }
        return new Temperature(newValue, newMeasure);
    }
}

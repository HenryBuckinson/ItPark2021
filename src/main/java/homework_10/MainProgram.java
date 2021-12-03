package homework_10;

public class MainProgram {
    public static void main(String[] args) {
        Temperature boilingWater = new Temperature(100, 'С');//на уровне моря
        boilingWater.displayTemperature();
        boilingWater.convertToCalvin().displayTemperature();
        boilingWater.convertToFahrenheit().displayTemperature();

        System.out.println();

        Temperature book = new Temperature(451, 'F');
        book.displayTemperature();
        book.convertToСelsius().displayTemperature();
        book.convertToCalvin().displayTemperature();

        System.out.println();


    }
}

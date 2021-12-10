package homework_11.AutoEnums;

/**
 * Перечисление с набором легковых авто.
 */
public enum Cars {
    FORD("Ford Focus"),
    AUDI("Audi R8"),
    VAZ("Lada Vesta"),
    CHEVROLET("Chevrolet Camaro"),
    MERCEDES("Mercedes SLC"),
    BMW("BMW M3"),
    MAZDA("Mazda RX-7"),
    TOYOTA("Toyota Supra"),
    NISSAN("Nissan GTR"),
    PORSCHE("Porsche 911");

    private final String model;

    Cars(String name) {
        this.model = name;
    }

    public String getModel() {
        return model;
    }
}

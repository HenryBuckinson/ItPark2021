package homework_11.AutoEnums;

public enum TruckConditions {
    MAX_PERMISSION_HEIGHT(4.0), MAX_PERMISSION_WEIGHT(8.0), MAX_PERMISSION_WIDTH(2.5);
    private double value;

    TruckConditions(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

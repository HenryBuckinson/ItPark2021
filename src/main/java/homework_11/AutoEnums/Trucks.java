package homework_11.AutoEnums;

public enum Trucks {
    SCANIA("Scania R-730"),
    MAN("MAN TGX"),
    DAF("DAF CF"),
    KAMAZ("Kamaz 43255"),
    MACK("Mack R685ST"),
    IVECO("Iveco S-way 480"),
    VOLVO("Volvo FH-16");

    private final String model;

    Trucks(String name) {
        this.model = name;
    }

    public String getModel() {
        return model;
    }
}

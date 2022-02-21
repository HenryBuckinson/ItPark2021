package homework_27.impls;


import homework_27.interfaces.PrototypePrinter;
import lombok.Data;

@Data
public class PrototypePrinterImpl implements PrototypePrinter {

    private int count = 0;

    @Override
    public void prototypePrint() {
        this.count = count + 1;
        System.out.print("Prototype bean text; Сreation counter = " + count);
        System.out.println(", and his hashCode: " + this.hashCode());
    }

}

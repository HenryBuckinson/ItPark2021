package homework_27.impls;

import homework_27.interfaces.PrototypePrinter;
import homework_27.interfaces.SingletonPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingletonPrinterImpl implements SingletonPrinter {


    private final PrototypePrinter protoPrinter;

    @Override
    public void singletonPrint() {
        System.out.println("Singleton-bean text and his hashCode: " + this.hashCode());
    }

    @Override
    public void advancePrint() {
        System.out.print("Используется прокси... ");
        protoPrinter.prototypePrint();
    }
}

package homework_27.impls;

import homework_27.interfaces.PrototypePrinter;
import homework_27.interfaces.SingletonPrinter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SingletonPrinterImpl implements SingletonPrinter {


    @Override
    public void singletonPrint() {
        System.out.println("Singleton bean text");
    }

    @Override
    public PrototypePrinter advancePrint() {
        System.out.print("Используется прокси...");
        return new PrototypePrinterImpl();
    }
}

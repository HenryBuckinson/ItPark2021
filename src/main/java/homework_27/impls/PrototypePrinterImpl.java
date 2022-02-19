package homework_27.impls;


import homework_27.interfaces.PrototypePrinter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PrototypePrinterImpl implements PrototypePrinter {

    @Override
    public void prototypePrint() {
        System.out.println("Prototype bean text");
    }
}

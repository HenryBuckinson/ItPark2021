package homework_19.base;

import java.math.BigDecimal;

public interface Accountable {
    void deposit(BigDecimal amount, Boolean permission);

    void withdraw(BigDecimal amount, Boolean permission);

}

package homework_19.base;

import java.math.BigDecimal;

public interface Accountable {
    void depositForJuridicalPersons(BigDecimal amount, Boolean permission);

    void withdrawForJuridicalPersons(BigDecimal amount, Boolean permission);

    void depositForIndividualPersons(BigDecimal amount);

    void withdrawForIndividualPersons(BigDecimal amount);
}

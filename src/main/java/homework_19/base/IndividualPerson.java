package homework_19.base;


import homework_19.annotations.Blocked;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class IndividualPerson implements Accountable {

    private BigDecimal money;
    private String name;
    private String surname;

    //    @Blocked
    @Override
    public void depositForIndividualPersons(BigDecimal amount) {
        this.money = this.money.add(amount);
        System.out.println("Операция пополнения прошла успешно!");
    }

    @Blocked
    @Override
    public void withdrawForIndividualPersons(BigDecimal amount) {
        this.money = this.money.subtract(amount);
        System.out.println("Операция снятия денежных средств прошла успешно!");
    }

    @Deprecated
    @Override
    public void depositForJuridicalPersons(BigDecimal amount, Boolean permission) {

    }

    @Deprecated
    @Override
    public void withdrawForJuridicalPersons(BigDecimal amount, Boolean permission) {

    }
}

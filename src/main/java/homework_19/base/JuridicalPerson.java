package homework_19.base;


import homework_19.annotations.Blocked;
import homework_19.exceptions.NoPermissionException;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class JuridicalPerson implements Accountable {

    private BigDecimal money;
    private String name;
    private String surname;
    private final String organization;

    @Override
    public void depositForJuridicalPersons(BigDecimal amount, @Blocked Boolean permission) {
        if (permission) {
            this.money = this.money.add(amount);
            System.out.println("Операция пополнения прошла успешно!");
        } else {
            System.out.print("У юридического лица " + this.name + " " + this.surname);
            throw new NoPermissionException(" нет разрешения на пополнение счета!");
        }
    }

    @Override
    public void withdrawForJuridicalPersons(BigDecimal amount, @Blocked() Boolean permission) {
        if (permission) {
            this.money = this.money.subtract(amount);
            System.out.println("Операция снятия денежных средств прошла успешно!");
        } else {
            System.out.print("У юридического лица " + this.name + " " + this.surname);
            throw new NoPermissionException(" нет разрешения на снятие денежных средств со счета!");
        }
    }

    @Deprecated
    @Override
    public void depositForIndividualPersons(BigDecimal amount) {

    }

    @Deprecated
    @Override
    public void withdrawForIndividualPersons(BigDecimal amount) {

    }
}

package homework_19.Base;


import homework_19.Annotations.Blocked;
import homework_19.Exceptions.NoPermissionException;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class IndividualPerson implements Accountable {

    private BigDecimal money;
    private String name;
    private String surname;

    @Override
    public void deposit(BigDecimal amount, @Blocked Boolean permission) {
        if (permission) {
            this.money = this.money.add(amount);
        } else {
            throw new NoPermissionException("Нет разрешения на пополнение счета!");
        }
    }

    @Override
    public void withdraw(BigDecimal amount, @Blocked Boolean permission) {
        if (permission) {
            this.money = this.money.subtract(amount);
        } else {
            throw new NoPermissionException("Нет разрешения на снятие со счета!");
        }
    }

}

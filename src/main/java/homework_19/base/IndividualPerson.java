package homework_19.base;


import homework_19.annotations.Blocked;
import homework_19.exceptions.NoPermissionException;
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
    public void deposit(BigDecimal amount, Boolean permission) {
        if (permission) {
            this.money = this.money.add(amount);
            System.out.println("Операция на пополнение счета прошла успешно!");
        } else {
            throw new NoPermissionException("Операция на пополнение счета отклонена!");
        }
    }

    @Blocked
    @Override
    public void withdraw(BigDecimal amount, Boolean permission) {
        if (permission) {
            this.money = this.money.subtract(amount);
            System.out.println("Операция снятия денежных средств прошла успешно!");
        } else {
            throw new NoPermissionException("Нет разрешения для снятия денежных средств!");
        }
    }
}

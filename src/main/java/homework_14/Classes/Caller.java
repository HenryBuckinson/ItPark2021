package homework_14.Classes;

import homework_14.Enums.TelecomsOperators;
import homework_14.MainProgram;
import homework_14.MyExceptions.ExistentNumberException;
import homework_14.MyExceptions.LengthNumberException;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Caller {
    private String fullName;
    private String number;//номер телефона объекта
    private Collection<String> phoneBook = new LinkedHashSet<>();//"Начальная" записная книга каждого объекта класса

    public String getNumber() {
        return number;
    }

    /**
     * @param fullName Полное имя абонента.
     * @param code     Код желаемого оператора связи.
     * @param number   Желаемый номер телефона. Вводится в формате 000-00-00.
     */
    public Caller(String fullName, TelecomsOperators code, String number) {
        if (number.length() > 9) {
            throw new LengthNumberException("Некорректный ввод номера телефона у абонента " + fullName + "!");
        }
        this.fullName = fullName;
        numberSetter(code, number);
        MainProgram.globalPhoneBook.put(this.number, this.phoneBook);
    }

    /**
     * @param code   Код оператора мобильной связи.
     * @param number Номера телефона введенный пользователем.
     *               Метод проверяет на уникальность номер телефона. Если такого номера не существует - он присваивается абоненту.
     *               В противном случае вызывается соответствующее исключение.
     */
    private void numberSetter(TelecomsOperators code, String number) {
        String result = code.getCode() + "-" + number;
        if (MainProgram.sequenceOfNumbers.contains(result)) {
            throw new ExistentNumberException("Данный номер телефона уже существует!");
        } else {
            MainProgram.sequenceOfNumbers.add(result);
            this.number = result;
        }
    }

    /**
     * @param caller объект класса Caller.
     *               Метод добавляет в записную книгу номер телефона объекта, который является аргументом метода.
     */
    public void addToPhoneBook(Caller caller) {
        phoneBook.add(caller.getNumber());
        MainProgram.globalPhoneBook.put(this.number, this.phoneBook);
    }

    @Override
    public String toString() {
        return "Caller{" +
                "fullName='" + fullName + '\'' +
                ", number='" + number + '\'' +
                ", phoneBook=" + phoneBook +
                '}';
    }

}

package homework_14.Classes;

import homework_14.Enums.TelecomsOperators;
import homework_14.MyExceptions.ExistentNumberException;
import homework_14.MyExceptions.LengthNumberException;

import java.util.*;

public class Caller {
    private String fullName;
    private String number;//номер телефона объекта
    private static Collection<String> sequenceOfNumbers = new HashSet<>();//Множество для хранения уникальных мобильных номеров
    //Каждый моб.номер в будущем будет уникальным ключом

    private String[] phoneBook = new String[0];//"Начальная" записная книга каждого объекта класса
    private static Map<String, String[]> globalPhoneBook = new HashMap<>();//Глобальный телефонный справочник, хранящий записные книги всех объектов
    //Ключ - моб.номер абонента; Значение - его записная книга

    public String getNumber() {
        return number;
    }

    public static Map<String, String[]> getGlobalPhoneBook() {
        return globalPhoneBook;
    }

    /**
     * @param fullName Полное имя абонента.
     * @param code     Код желаемого оператора связи.
     * @param number   Желаемый номер телефона. Вводится в формате 000-00-00.
     */
    public Caller(String fullName, TelecomsOperators code, String number) {
        if (number.length() > 9) {
            throw new LengthNumberException("Некорректный ввод номера телефона!");
        }
        this.fullName = fullName;
        numberSetter(code, number);
        globalPhoneBook.put(this.number, this.phoneBook);
    }

    /**
     * @param code   Код оператора мобильной связи.
     * @param number Номера телефона введенный пользователем.
     *               Метод проверяет на уникальность номер телефона. Если такого номера не существует - он присваивается абоненту.
     *               В противном случае вызывается соответствующее исключение.
     */
    private void numberSetter(TelecomsOperators code, String number) {
        String result = code.getCode() + "-" + number;
        if (sequenceOfNumbers.contains(result)) {
            throw new ExistentNumberException("Данный номер телефона уже существует!");
        } else {
            sequenceOfNumbers.add(result);
            this.number = result;
        }
    }

    /**
     * @param caller объект класса Caller.
     *               Метод добавляет в записную книгу номер телефона объекта, который является аргументом метода.
     */
    public void addToPhoneBook(Caller caller) {
        LinkedList<String> phoneBookList = new LinkedList<>(Arrays.asList(phoneBook));
        phoneBookList.add(caller.getNumber());
        String[] resultArray = phoneBookList.toArray(new String[0]);
        phoneBook = resultArray;
        globalPhoneBook.put(this.number, this.phoneBook);
    }

    @Override
    public String toString() {
        return "Caller{" +
                "fullName='" + fullName + '\'' +
                ", number='" + number + '\'' +
                ", phoneBook=" + Arrays.toString(phoneBook) +
                '}';
    }
}

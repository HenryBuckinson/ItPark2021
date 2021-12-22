package homework_14;

import homework_14.Classes.Caller;
import homework_14.Enums.TelecomsOperators;
import homework_14.MyExceptions.ExistentNumberException;
import homework_14.MyExceptions.LengthNumberException;

import java.util.*;

public class MainProgram {

    public static Collection<String> sequenceOfNumbers = new HashSet<>();//Множество для хранения уникальных мобильных номеров
    //Каждый мобильный номер в будущем будет уникальным ключом

    public static Map<String, Collection<String>> globalPhoneBook = new HashMap<>();//Глобальный телефонный справочник, хранящий записные книги всех объектов
    //Ключ - моб.номер абонента; Значение - его записная книга

    public static void main(String[] args) {
        try {
            System.out.println();
            Caller user1 = new Caller("Mister White", TelecomsOperators.REDLINE, "987-65-54");//Далее будет самым непопулярным номером
            Caller user2 = new Caller("Mister Blonde", TelecomsOperators.BEELINK, "989-88-54");
            Caller user3 = new Caller("Mister Orange", TelecomsOperators.TELECOURSE, "768-22-28");
            Caller user4 = new Caller("Mister Blue", TelecomsOperators.GREENLINE, "987-49-21");
            Caller user5 = new Caller("Mister Brown", TelecomsOperators.BEELINK, "593-83-23");
            Caller user6 = new Caller("Mister Pink", TelecomsOperators.REDLINE, "678-72-88");
            Caller user7 = new Caller("Good Guy", TelecomsOperators.TELECOURSE, "188-44-99");//Далее будет самым популярным номером

            //--Заполнение телефонной книги каждого абонента--//
            user1.addToPhoneBook(user2);
            user2.addToPhoneBook(user1);
            user2.addToPhoneBook(user3);
            user3.addToPhoneBook(user2);
            user3.addToPhoneBook(user4);
            user4.addToPhoneBook(user3);
            user4.addToPhoneBook(user5);
            user5.addToPhoneBook(user4);
            user5.addToPhoneBook(user6);
            user6.addToPhoneBook(user5);
            user6.addToPhoneBook(user7);
            user7.addToPhoneBook(user6);
            user1.addToPhoneBook(user7);
            user2.addToPhoneBook(user7);
            user3.addToPhoneBook(user7);
            user4.addToPhoneBook(user7);
            user5.addToPhoneBook(user7);

            //--Печать списка существующих абонентов--//
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);
            System.out.println(user5);
            System.out.println(user6);
            System.out.println(user7);

            System.out.println();

            getPopularNumber();
            getUnpopularNumber();

        } catch (ExistentNumberException | LengthNumberException a) {
            System.out.println(a.getMessage());
        }
    }

    /**
     * Метод отображает самый популярный номер телефона в записных книгах существующих абонентов.
     */
    static void getPopularNumber() {
        Map<String, Integer> resultList = new HashMap<>();
        int count = 0;
        for (String number : sequenceOfNumbers) {//Пробег по опорным номерам
            for (Map.Entry<String, Collection<String>> entry : globalPhoneBook.entrySet()) {//Пробег по ключ-значение карты
                for (String items : entry.getValue()) {//Пробег по значению карты
                    if (number.equals(items)) {
                        resultList.put(number, ++count);
                    }
                }
            }
            count = 0;
        }
        Integer maxValueOfKey = Collections.max(resultList.values());
        for (Map.Entry<String, Integer> entry : resultList.entrySet()) {
            if (maxValueOfKey.equals(entry.getValue())) {
                System.out.println("Самый популярный номер среди телефонных книг абонентов: " + entry.getKey());
            }
        }
    }

    /**
     * Метод отображает самый непопулярный номер телефона в записных книгах существующих абонентов.
     */
    static void getUnpopularNumber() {
        Map<String, Integer> resultList = new HashMap<>();
        int count = 0;
        for (String number : sequenceOfNumbers) {//Пробег по опорным номерам
            for (Map.Entry<String, Collection<String>> entry : globalPhoneBook.entrySet()) {//Пробег по ключ-значение карты
                for (String items : entry.getValue()) {//Пробег по значению карты
                    if (number.equals(items)) {
                        resultList.put(number, ++count);
                    }
                }
            }
            count = 0;
        }
        Integer minValueOfKey = Collections.min(resultList.values());
        for (Map.Entry<String, Integer> entry : resultList.entrySet()) {
            if (minValueOfKey.equals(entry.getValue())) {
                System.out.println("Самый непопулярный номер среди телефонных книг абонентов: " + entry.getKey());
            }
        }
    }

}

package homework_14;

import homework_14.Classes.Caller;
import homework_14.Enums.TelecomsOperators;

public class MainProgram {
    public static void main(String[] args) {
        Caller user1 = new Caller("Mister White", TelecomsOperators.REDLINE, "987-65-54");
        Caller user2 = new Caller("Mister Blonde", TelecomsOperators.BEELINK, "998-34-43");
        Caller user3 = new Caller("Mister Orange", TelecomsOperators.TELECOURSE, "768-22-28");
        Caller user4 = new Caller("Mister Blue", TelecomsOperators.GREENLINE, "987-49-21");
        Caller user5 = new Caller("Mister Brown", TelecomsOperators.BEELINK, "593-83-23");
        Caller user6 = new Caller("Mister Pink", TelecomsOperators.REDLINE, "678-72-88");
        Caller user7 = new Caller("Good Guy", TelecomsOperators.TELECOURSE, "188-44-99");

        //Caller user8 = new Caller("Good Guy",TelecomsOperators.REDLINE,"987-65-54");  //Выдает исключение ExistentNumberException т.к. номер совпадает с user1

        {
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
        }   //Заполнение телефонных книг у объектов класса Caller
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5);
        System.out.println(user6);
        System.out.println(user7);
        System.out.println();
        System.out.println(Caller.getGlobalPhoneBook());
        System.out.println();
    }
}

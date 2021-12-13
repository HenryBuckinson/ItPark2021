package homework_12;

import homework_12.Classes.StringMatrix;
import homework_12.Exceptions.MyArrayDataException;
import homework_12.Exceptions.MyArraySizeException;

public class MainProgram {
    public static void main(String[] args) {
        try {
            StringMatrix strMatrix = new StringMatrix(4, 4);
            strMatrix.fillingArray();
            System.out.println(strMatrix);
            int result = strMatrix.countIntegerElements();
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException a) {
            System.out.println(a.getMessage());
        }


    }
}

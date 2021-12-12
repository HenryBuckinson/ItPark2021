package homework_12;

import homework_12.Classes.StringMatrix;

public class MainProgram {
    public static void main(String[] args) {
        StringMatrix strMatrix = new StringMatrix(4, 4);
        strMatrix.fillingArray();
        System.out.println(strMatrix);
        int result = strMatrix.countIntegerElements();
        System.out.println(result);


    }
}

package homework_12;

import homework_12.Classes.StringMatrix;
import homework_12.Classes.StringMatrixOperations;
import homework_12.Interfaces.Customizable;

public class MainProgram implements Customizable {
    public static void main(String[] args) {
        StringMatrix strMatrix = new StringMatrix(4, 4);
        StringMatrixOperations operation = new StringMatrixOperations();
        int result = operation.countIntegerElements(strMatrix);
        System.out.println(result);

    }
}

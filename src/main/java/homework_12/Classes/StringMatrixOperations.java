package homework_12.Classes;

import homework_12.Exceptions.MyArrayDataException;
import homework_12.Exceptions.MyArraySizeException;
import homework_12.Interfaces.Customizable;

public class StringMatrixOperations implements Customizable {

    public StringMatrixOperations() {
    }

    @Override
    public int countIntegerElements(StringMatrix strMatrix) {
        int rows = strMatrix.getRows();
        int columns = strMatrix.getColumns();
        if (rows != 4 | columns != 4) {
            throw new MyArraySizeException("Аргумент метода должен содержать массив размером 4 на 4!");
        }
        String[][] strArray = strMatrix.getStrArray();
        int sum = 0;

        for (int i = 0; i < strArray.length; i++) {
            String[] strings = strArray[i];
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Конфликт при работе с элементом \"" + string + "\" на позиции [" + i + "] и [" + j + "]");
                }
            }
        }
        return sum;
    }
}

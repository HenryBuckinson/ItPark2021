package homework_12.Classes;

import homework_12.Exceptions.MyArrayDataException;
import homework_12.Exceptions.MyArraySizeException;
import homework_12.Interfaces.Countable;

import java.util.Scanner;

public class StringMatrix implements Countable {
    private final String[][] strArray;
    private final int rows;
    private final int columns;

    public StringMatrix(int rows, int columns) throws MyArraySizeException {
        if (rows != 4 | columns != 4) {
            throw new MyArraySizeException("Ошибка! Массив должен быть размером строго 4 на 4.");
        }
        this.rows = rows;
        this.columns = columns;
        strArray = new String[rows][columns];
    }

    public void fillingArray() throws MyArraySizeException {
        System.out.println("Начинаем заполнение массива...");
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                Scanner scn = new Scanner(System.in);
                strArray[i][j] = scn.next();
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("Двумерный массив имеет вид: ");
        String result = "";
        for (String[] strings : strArray) {
            for (String string : strings) {
                result += " | " + string + " | ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public int countIntegerElements() {
        int sum = 0;
        for (int i = 0; i < strArray.length; i++) {
            String[] strings = strArray[i];
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка! Конфликт при работе с элементом \"" + string + "\" на позиции [" + i + "] и [" + j + "]");
                }
            }
        }
        return sum;
    }
}

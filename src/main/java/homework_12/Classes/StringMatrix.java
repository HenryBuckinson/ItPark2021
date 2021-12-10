package homework_12.Classes;

import homework_12.Exceptions.MyArraySizeException;

import java.util.Scanner;

public class StringMatrix {
    private final String[][] strArray;
    private final int rows;
    private final int columns;

    public StringMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        strArray = new String[rows][columns];
        fillingArray();
        showArray();
    }

    public String[][] getStrArray() {
        return strArray;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private void fillingArray() throws MyArraySizeException {
        System.out.println("Начинаем заполнение массива...");
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                Scanner scn = new Scanner(System.in);
                strArray[i][j] = scn.next();
            }
        }
    }

    private void showArray() {
        System.out.println("Двумерный массив имеет вид: ");
        for (String[] strings : strArray) {
            for (String string : strings) {
                System.out.print(" | " + string + " | ");
            }
            System.out.println();
        }
    }
}

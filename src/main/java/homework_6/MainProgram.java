package homework_6;

import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        int[] res = fillArray();
        System.out.println(Arrays.toString(res));
        minValueOfArray(res);
        maxValueOfArray(res);
        System.out.println("Среднее значение элементов массива = " + avgOfArray(res));
    }

    /**
     * @return Результатом метод возвращает массив целых чисел в диапазоне от 0 до 10 включительно. Длина массива задаётся по запросу
     * пользователя.
     */
    public static int[] fillArray() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите желаемую длину массива:");
        int lengthArray = 0;
        while (scn.hasNextInt() || scn.hasNext()) {
            if (scn.hasNextInt()) {
                int test = scn.nextInt();
                if (test > 0) {
                    lengthArray = test;
                    break;
                } else {
                    System.out.println("Длина массива не может быть отрицательной величиной. Введите значение заново: ");
                }
            } else if (scn.hasNext()) {
                System.out.println("Некорректный ввод. Введите значение заново: ");
                scn.next();
            }
        }
        int[] resultArray = new int[lengthArray];
        Random rnd = new Random();
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = rnd.nextInt(11);
        }
        return resultArray;
    }

    /**
     * @param array Одномерный целочисленный массив.
     *              Результатом метод отображает значение наименьшего элемента массива, который передается
     *              в качестве аргумента.
     */
    public static void minValueOfArray(int[] array) {
        Arrays.sort(array);
        if (array[0] == array[1]) {
            System.out.println("Одинаковых минимальных значений больше двух. Минимальное значение = " + array[0]);
        } else {
            System.out.println("Минимальное значение = " + array[0]);
        }
    }

    /**
     * @param array Одномерный целочисленный массив.
     *              Результатом метод отображает значение наибольшего элемента массива, который передается
     *              в качестве аргумента.
     */
    public static void maxValueOfArray(int[] array) {
        Arrays.sort(array);
        if (array[array.length - 1] == array[array.length - 2]) {
            System.out.println("Одинаковых максимальных значений больше двух. Максимальное значение = " + array[array.length - 1]);
        } else {
            System.out.println("Максимальное значение = " + array[array.length - 1]);
        }
    }

    /**
     * @param array Одномерный целочисленный массив.
     * @return Результатом метод возвращает среднее значение элементов массива, округлённого до трёх знаков после запятой.
     */
    public static double avgOfArray(int[] array) {
        double sum = 0;
        for (int j : array) {
            sum += j;
        }
        double scale = Math.pow(10, 3);
        return Math.ceil((sum / array.length) * scale) / scale;
    }
}

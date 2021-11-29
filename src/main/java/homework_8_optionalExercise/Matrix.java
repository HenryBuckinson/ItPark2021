package homework_8_optionalExercise;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Matrix {
    private int m;
    private int n;
    private int[][] saveValues = new int[m][n];


    public Matrix() {
        this.m = 2;
        this.n = 2;
    }

    public Matrix(int rows, int columns) {
        this.m = rows;
        this.n = columns;
    }

    public Matrix(int i, int j, int[][] array) {
        this.m = i;
        this.n = j;
        this.saveValues = array;
    }

    /**
     * @return Результатом метод возвращает значение соответствующее количеству строк в матрице.
     */
    public int getRows() {
        return m;
    }

    /**
     * @return Результатом метод возвращает значение соответствующее количеству столбцов в матрице.
     */
    public int getCols() {
        return n;
    }

    /**
     * @return Результатом метод возвращает двумерный массив представляющий матрицу.
     */
    public int[][] getMatrix() {
        return saveValues;
    }


    /**
     * Метод заполняет матрицу целыми числами по запросу пользователя.
     */
    public void fillingOfMatrix() {
        int[][] result = new int[m][n];
        System.out.println("Начинаем заполнение матрицы, введите значения: ");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                while (!scn.hasNextInt()) {
                    System.out.print("Некорректный ввод, введите значение заново: ");
                    scn.next();
                }
                result[i][j] = scn.nextInt();
            }
        }
        saveValues = result;
    }

    /**
     * Метод отображает матрицу в консоль.
     */
    public void showMatrix() {
        System.out.println("Отображение матрицы: ");
        for (int[] saveValue : saveValues) {
            for (int i : saveValue) {
                System.out.print("|" + i + "| ");
            }
            System.out.println();
        }
    }

    /**
     * @param A объект матрицы.
     * @return Результатом метод возвращает объект матрицы получающийся суммированием с аргументом, который содержит объект матрицу.
     */
    public Matrix sum(Matrix A) {
        if (this.getCols() != A.getCols() | this.getRows() != A.getRows()) {
            throw new ArithmeticException("Нельзя суммировать матрицы разных размеров.");
        }
        System.out.println("Суммирование матриц: ");
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] + A.saveValues[i][j];
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param A объект единичной матрицы.
     * @return Результатом метод возвращает объект матрицы получающийся суммированием с аргументом, который содержит объект единичной матрицы.
     */
    public Matrix sum(unitMatrix A) {
        if (this.getCols() != A.getCols() | this.getRows() != A.getRows()) {
            throw new ArithmeticException("Нельзя суммировать матрицы разных размеров.");
        }
        System.out.println("Суммирование с единичной матрицей:");
        int[][] unitMat = A.getArrayOfUnitMatrix();
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] + unitMat[i][j];
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param A объект матрицы.
     * @return Результатом метод возвращает объект матрицы после вычитания аргумента, который содержит объект матрицу.
     */
    public Matrix diff(Matrix A) {
        if (this.getCols() != A.getCols() | this.getRows() != A.getRows()) {
            throw new ArithmeticException("Нельзя вычитать матрицы разных размеров.");
        }
        System.out.println("Результат разности матриц:");
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] - A.saveValues[i][j];
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param A объект единичной матрицы.
     * @return Результатом метод возвращает объект матрицы после вычитания аргумента, который содержит объект единичной матрицы.
     */
    public Matrix diff(unitMatrix A) {
        if (this.getCols() != A.getCols() | this.getRows() != A.getRows()) {
            throw new ArithmeticException("Нельзя вычитать матрицы разных размеров.");
        }
        System.out.println("Суммирование с единичной матрицей:");
        int[][] unitMat = A.getArrayOfUnitMatrix();
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] - unitMat[i][j];
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @return Результатом метод возвращает объект, содержащий транспонированную матрицу.
     */
    public Matrix invert() {
        System.out.println("Получение транспонированной матрицы...");
        int[][] result = new int[this.n][this.m];
        if (m == n) {   //обратииить вниманиие
            for (int i = 0; i < saveValues.length; i++) {
                for (int j = 0; j < saveValues[i].length; j++) {
                    result[i][j] = saveValues[j][i];
                }
            }
        }
        if (n > m) {
            int[] help = new int[n * m];
            int count = 0;
            int count2 = 0;
            int k = 0;
            while (count2 < n * m) {
                for (int i = 0; i < m; i++) {
                    if (i == n) {
                        break;
                    }
                    help[count2] = saveValues[i][k];
                    count2++;
                }
                k++;
            }
            count = 0;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    while (count < help.length) {
                        result[i][j] = help[count];
                        count++;
                        break;
                    }
                }
            }
        }
        if (n < m) {
            int[] help = new int[n * m];
            int count = 0;
            int count2 = 0;
            int k = 0;
            while (count2 < n * m) {
                for (int i = 0; i < m; i++) {
                    if (i == m) {
                        break;
                    }
                    help[count2] = saveValues[i][k];
                    count2++;
                }
                k++;
            }
            count = 0;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    while (count < help.length) {
                        result[i][j] = help[count];
                        count++;
                        break;
                    }
                }
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param multiplier множитель матрицы.
     * @return Результатом метод возвращает объект матрицы, после произведения на аргумент метода.
     */
    public Matrix multiply(int multiplier) {
        System.out.println("Умножение матрицы на число " + multiplier + "...");
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] * multiplier;
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param k порядок степени.
     * @return Результатом метод возвращает объект матрицы, после возведения в степень каждого элемента матрицы.
     */
    public Matrix pow(int k) {
        System.out.println("Возведение матрицы в степень " + k + "...");
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] * saveValues[i][j];
                int c = k;
                c -= 2;
                while (c > 0) {
                    result[i][j] *= saveValues[i][j];
                    c--;
                }
            }
        }
        return new Matrix(m, n, result);
    }

    /**
     * @param A объект матрицы.
     * @return Результатом метод возвращает новый объект матрицы, который является результатом произведения двух матриц.
     */
    public Matrix multiply(Matrix A) {
        if (this.getCols() != A.getRows()) {
            throw new ArithmeticException("Количество столбцов первой матрицы не равно количеству строк второй матрицы.");
        }
        System.out.println("Перемножение матриц: ");
        int count1 = 0;
        int count2 = 0;
        int[][] res = new int[m][n];
        int[] resHelp = new int[m * n];
        int[] saveValueHelp = new int[m * n];
        for (int[] saveValue : saveValues) {
            for (int i : saveValue) {
                while (count1 < saveValueHelp.length) {
                    saveValueHelp[count1] = i;
                    count1++;
                    break;
                }
            }
        }   // "Копирую эл-ты "this" двумерного массива в одномерный массив
        int[][] arg = A.invert().getMatrix();
        int[] argHelp = new int[A.getCols() * A.getRows()];
        for (int[] ints : arg) {
            for (int j = 0; j < ints.length; j++) {
                while (count2 < argHelp.length) {
                    argHelp[count2] = ints[j];
                    count2++;
                    break;
                }
            }
        }   //Копирую эл-ты А двумерного массива в одномерный массив
        if (A.getCols() < this.getCols()) {
            res = new int[m][A.getCols()];
        }
        if (A.getCols() > this.getRows()) {
            res = new int[m][A.getCols()];
            resHelp = new int[m * A.getCols()];
        }
        int sum = 0;
        int index = 0;
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < saveValueHelp.length; i = i + n) {
            while (true) {
                if (count2 == n) {
                    Array.set(resHelp, index, sum);
                    index++;
                    count2 = 0;
                    sum = 0;
                    if (index == resHelp.length) {
                        count1 = 0;
                        count2 = 0;
                        break;
                    }
                    continue;
                }
                if (count1 == argHelp.length) {
                    count1 = 0;
                    count2 = 0;
                    break;
                }
                sum += saveValueHelp[i + count2] * argHelp[count1];
                count2++;
                count1++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                while (count1 < resHelp.length) {
                    res[i][j] = resHelp[count1];
                    count1++;
                    break;
                }
            }
        }   //Копирование рассчитанных эл-ов из одномерного массива в итоговый
        return new Matrix(m, n, res);
    }

}

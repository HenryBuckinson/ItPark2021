package homework_8_optionalExercise;

import java.util.Scanner;

public class Matrix {
    private int row;
    private int column;
    private int[][] objArray = new int[row][column];

    public Matrix() {
        this.row = 2;
        this.column = 2;
    }

    public Matrix(int rows, int columns) {
        this.row = rows;
        this.column = columns;
    }

    public Matrix(int i, int j, int[][] array) {
        this.row = i;
        this.column = j;
        this.objArray = array;
    }

    /**
     * @param order Конструктор создания единичной матрицы
     */
    public Matrix(int order) {
        this.row = order;
        this.column = order;
        fillingUnitMatrix();
    }

    /**
     * @return Результатом метод возвращает значение соответствующее количеству строк в матрице.
     */
    public int getRows() {
        return row;
    }

    /**
     * @return Результатом метод возвращает значение соответствующее количеству столбцов в матрице.
     */
    public int getCols() {
        return column;
    }

    /**
     * @return Результатом метод возвращает двумерный массив представляющий матрицу.
     */
    public int[][] getMatrix() {
        return objArray;
    }

    /**
     * Результатом метод заполняет формирует единичную матрицу.
     */
    private void fillingUnitMatrix() {
        System.out.println("Создание единичной матрицы...");
        int[][] result = new int[row][column];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        objArray = result;
    }

    /**
     * Метод заполняет матрицу целыми числами по запросу пользователя.
     */
    public void fillingOfMatrix() {
        int[][] result = new int[row][column];
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
        objArray = result;
    }

    /**
     * Метод отображает матрицу в консоль.
     */
    public void showMatrix() {
        System.out.println("Отображение матрицы: ");
        for (int[] saveValue : objArray) {
            for (int i : saveValue) {
                System.out.print("|" + i + "| ");
            }
            System.out.println();
        }
    }

    /**
     * @param argMatrix объект матрицы.
     * @return Результатом метод возвращает объект матрицы получающийся суммированием с аргументом, который содержит объект матрицу.
     */
    public Matrix sum(Matrix argMatrix) {
        if (this.getCols() != argMatrix.getCols() | this.getRows() != argMatrix.getRows()) {
            throw new ArithmeticException("Нельзя суммировать матрицы разных размеров.");
        }
        System.out.println("Суммирование матриц: ");
        int[][] result = new int[row][column];
        for (int i = 0; i < objArray.length; i++) {
            for (int j = 0; j < objArray[i].length; j++) {
                result[i][j] = objArray[i][j] + argMatrix.objArray[i][j];
            }
        }
        return new Matrix(row, column, result);
    }

    /**
     * @param argMatrix объект матрицы.
     * @return Результатом метод возвращает объект матрицы после вычитания аргумента, который содержит объект матрицу.
     */
    public Matrix diff(Matrix argMatrix) {
        if (this.getCols() != argMatrix.getCols() | this.getRows() != argMatrix.getRows()) {
            throw new ArithmeticException("Нельзя вычитать матрицы разных размеров.");
        }
        System.out.println("Результат разности матриц:");
        int[][] result = new int[row][column];
        for (int i = 0; i < objArray.length; i++) {
            for (int j = 0; j < objArray[i].length; j++) {
                result[i][j] = objArray[i][j] - argMatrix.objArray[i][j];
            }
        }
        return new Matrix(row, column, result);
    }

    /**
     * @return Результатом метод возвращает объект, содержащий транспонированную матрицу.
     */
    public Matrix invert() {
        System.out.println("Получение транспонированной матрицы...");
        int[][] result = new int[objArray[0].length][objArray.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = objArray[j][i];
            }
        }
        return new Matrix(row, column, result);
    }

    /**
     * @param multiplier множитель матрицы.
     * @return Результатом метод возвращает объект матрицы, после произведения на аргумент метода.
     */
    public Matrix multiply(int multiplier) {
        System.out.println("Умножение матрицы на число " + multiplier + "...");
        int[][] result = new int[row][column];
        for (int i = 0; i < objArray.length; i++) {
            for (int j = 0; j < objArray[i].length; j++) {
                result[i][j] = objArray[i][j] * multiplier;
            }
        }
        return new Matrix(row, column, result);
    }

    /**
     * @param order порядок степени.
     * @return Результатом метод возвращает объект матрицы, после возведения в степень каждого элемента матрицы.
     */
    public Matrix pow(int order) {
        System.out.println("Возведение матрицы в степень " + order + "...");
        int[][] result = new int[row][column];
        for (int i = 0; i < objArray.length; i++) {
            for (int j = 0; j < objArray[i].length; j++) {
                result[i][j] = (int) Math.pow(objArray[i][j], order);
            }
        }
        return new Matrix(row, column, result);
    }

    /**
     * @param argMatrix объект матрицы.
     * @return Результатом метод возвращает новый объект матрицы, который является результатом произведения двух матриц.
     */
    public Matrix multiply(Matrix argMatrix) {
        int[][] result = new int[1][1];
        int[][] secondMatrix = argMatrix.getMatrix();//Извлекается матрица из аргумента метода
        if (objArray[0].length != secondMatrix.length) {
            throw new ArithmeticException("Количество столбцов первой матрицы не равно количеству строк второй матрицы.");
        }//Сравнение столбцов первой и строк второй матрицы
        if ((objArray.length == secondMatrix.length) & (objArray[0].length == secondMatrix[0].length)) {
            int[][] res = new int[objArray.length][secondMatrix.length];
            result = res;
        }//Сравнение строк и столбцов матриц, уместно когда обе матрицы квадратные
        if ((objArray.length >= secondMatrix.length & objArray[0].length <= secondMatrix[0].length)
                | (objArray.length <= secondMatrix.length & objArray[0].length >= secondMatrix[0].length)
                | (objArray.length <= secondMatrix.length & objArray[0].length <= secondMatrix[0].length)) {
            int[][] res = new int[objArray.length][secondMatrix[1].length];
            result = res;
        }//Сравнение строк и столбцов матриц, уместно когда перемножаемые матрицы имеют разные размеры
        System.out.println("Перемножение матриц...");
        int sum = 0;
        for (int j = 0; j < result.length; j++) {
            for (int k = 0; k < result[j].length; k++) {
                sum = 0;
                for (int l = 0; l < secondMatrix.length; l++) {
                    sum += objArray[j][l] * secondMatrix[l][k];
                }
                result[j][k] = sum;
            }
        }//Алгоритм перемножения
        return new Matrix(row, column, result);
    }
}

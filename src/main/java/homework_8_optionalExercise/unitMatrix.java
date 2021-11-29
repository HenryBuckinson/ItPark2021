package homework_8_optionalExercise;

public class unitMatrix extends Matrix {
    private int m;
    private int n;
    private int[][] saveValues = new int[m][n];

    public unitMatrix() {
        super();
        fillingUnitMatrix();
    }

    public unitMatrix(int order) {
        super(order, order);
        this.m = order;
        this.n = order;
        fillingUnitMatrix();
    }

    /**
     * @return Результатом метод возвращает двумерный массив, представляющий единичную матрицу.
     */
    public int[][] getArrayOfUnitMatrix() {
        return saveValues;
    }

    private void fillingUnitMatrix() {
        System.out.println("Создание единичной матрицы...");
        int[][] result = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        saveValues = result;
    }

    /**
     * Метод отображает матрицу в консоль.
     */
    @Override
    public void showMatrix() {
        System.out.println("Единичная матрица порядка " + m + " имеет вид:");
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                System.out.print("|" + saveValues[i][j] + "| ");
            }
            System.out.println();
        }
    }

    /**
     * @param multiplier множитель матрицы.
     * @return Результатом метод возвращает объект класса Matrix, получающийся умножением единичной матрицы на аргумент метода.
     */
    @Override
    public Matrix multiply(int multiplier) {
        System.out.println("Умножение единичной матрицы на число " + multiplier + " ...");
        int[][] result = new int[m][n];
        for (int i = 0; i < saveValues.length; i++) {
            for (int j = 0; j < saveValues[i].length; j++) {
                result[i][j] = saveValues[i][j] * multiplier;
            }
        }
        return new Matrix(m, n, result);
    }
}

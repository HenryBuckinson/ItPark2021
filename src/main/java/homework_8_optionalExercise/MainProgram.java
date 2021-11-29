package homework_8_optionalExercise;

public class MainProgram {
    public static void main(String[] args) {
        Matrix test2 = new Matrix(3, 3);
        test2.fillingOfMatrix();
        test2.showMatrix();

        Matrix test3 = new Matrix(3,4);
        test3.fillingOfMatrix();
        test3.invert().showMatrix();    //test3.showMatrix(); - когда умножаем test2 и test3

//        Matrix multiplyResult = test2.multiply(test3);
//        multiplyResult.invert();


    }

    public static Matrix matrixInverted(Matrix obj) {
        int[][] fromObj = obj.getMatrix();
        int m = obj.getRows();
        int n = obj.getCols();
        int[][] result = new int[m][n];
        System.out.println("Получение транспонированной матрицы:");
        if (m == n) {
            for (int i = 0; i < fromObj.length; i++) {
                for (int j = 0; j < fromObj[i].length; j++) {
                    result[i][j] = fromObj[j][i];
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
                    help[count2] = fromObj[i][k];
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
                    help[count2] = fromObj[i][k];
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
}

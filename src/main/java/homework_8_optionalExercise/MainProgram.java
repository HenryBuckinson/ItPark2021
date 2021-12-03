package homework_8_optionalExercise;

public class MainProgram {
    public static void main(String[] args) {
        Matrix test1 = new Matrix(3, 2);
        test1.fillingOfMatrix();
        test1.showMatrix();


    }

    public static Matrix matrixInverted(Matrix obj) {
        int[][] argMatrix = obj.getMatrix();
        int m = obj.getRows();
        int n = obj.getCols();
        int[][] result = new int[n][m];
        System.out.println("Получение транспонированной матрицы...");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = argMatrix[j][i];
            }
        }

        return new Matrix(m, n, result);
    }
}

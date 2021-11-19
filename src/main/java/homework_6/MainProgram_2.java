package homework_6;

public class MainProgram_2 {
    public static int[] cashArray = new int[46];

    public static void main(String[] args) {
        cashArray[0] = 0;
        cashArray[1] = 1;
        System.out.println(getFibsNumbers(0));
        System.out.println(getFibsNumbers(1));
        System.out.println(getFibsNumbers(6));
        System.out.println(getFibsNumbers(3));
        System.out.println(getFibsNumbers(4));
        System.out.println(getFibsNumbers(12));
        System.out.println(getFibsNumbers(10));
        System.out.println(getFibsNumbers(-50));
        System.out.println(getFibsNumbers(45));
        System.out.println(getFibsNumbers(17));
        System.out.println(getFibsNumbers(100));
    }

    /**
     * @param index Индекс элемента массива-поля.
     * @return Результатом метод возвращает значение индекса последовательности чисел Фибоначчи, которые хранятся
     * в массиве-поле. Если аргумент метода отрицательный - используется минимальное допустимое значение для последовательности.
     * Если аргумент метода больше длинны массива-поля - используется максимальное допустимое значение для последовательности.
     */
    public static int getFibsNumbers(int index) {
        if (index < 0) {
            index = 0;
        } else if (index > cashArray.length) {
            index = cashArray.length - 1;
        } else if (index == 0 | index == 1) {
            return cashArray[index];
        } else if (cashArray[index] == 0) {
            for (int i = 1; i <= index; i++) {
                if (cashArray[i] != 0) {
                    continue;
                } else {
                    cashArray[i] = cashArray[i - 1] + cashArray[i - 2];
                }
            }
        }
        return cashArray[index];
    }
}

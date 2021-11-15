package homework_5;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("Значение порядкового номера последовательности: " + numberOfFibs());

    }

    /**
     * @return Результатом метод возвращает значение порядкового номера в последовательности Фибоначчи, которое пользователь вводит в консоль.
     * Ограничение: Число вводимое пользователем должно быть положительным, и не превышать 50. При вводе значения выше 50,
     * используется значение верхней допустимой границы.
     * Если вводится значение равное 0 или меньше, используется значение нижней допустиммой границы.
     */
    public static long numberOfFibs() {
        long result = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите порядковый номер из последовательности Фибоначчи: ");
        while (!scn.hasNextLong()) {
            System.out.println("Ошибка при вводе, введите значение заново:");
            scn.next();
        }
        long orderNum = scn.nextLong();
        if (orderNum > 50) {
            orderNum = 50;
        } else if (orderNum < 0) {
            orderNum = 1;
        }
        long prevNumber = 1;
        long nextNumber = 1;
        for (long i = 1; i < 51; i++) {
            if (i == orderNum) {
                result = prevNumber;
                break;
            }
            nextNumber = prevNumber + nextNumber;
            prevNumber = nextNumber - prevNumber;
        }
        return result;
    }
}

package homework_4;

import javax.swing.*;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("Результат метода \"trickySqrt\": " + trickySqrt());
        customSqrt();


    }

    /**
     * @return Результатом метод возвращает целочисленное значение квадратного корня от числа, которое передается
     * пользователем в консоль
     */
    public static long trickySqrt() {
        System.out.println("Введите число:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        long result;
        try {
            long value = Long.parseLong(str);
            if (value < 0) {
                throw new ArithmeticException();
            }
            result = (long) Math.pow(value, 0.5);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Число должно быть положительным");
        } catch (Exception e) {
            throw new NumberFormatException("Произошла ошибка при вводе числа!");
        }
        return result;
    }

    /**
     * Результатом метод отображает значение квадратного корня от числа, которое вводится
     * пользователем через диалоговое окно
     */
    public static void customSqrt() {
        String str = JOptionPane.showInputDialog("Введите целое число: ");
        try {
            long value = Long.parseLong(str);
            if (value < 0) {
                JOptionPane.showMessageDialog(null, "Число должно быть положительным", "Error", JOptionPane.ERROR_MESSAGE);
                throw new ArithmeticException();
            }
            long count = 0;
            long j = 1;
            for (long i = value; i > 0; j += 2) {
                i -= j;
                count++;
            }
            JOptionPane.showMessageDialog(null, "Результат расчета: " + count, "Окончание расчёта", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка при вводе", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

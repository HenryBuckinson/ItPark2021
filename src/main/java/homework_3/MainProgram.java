package homework_3;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println("Расчёт факториала числа - " + factorial(5));
        System.out.println("Расчёт квадратного уравнения - " + quadraticEquation(4, 0, 8));
    }

    /**
     * @param n Целочисленный входной параметр
     * @return Метод результатом возвращает факториал числа, переданного аргументом методу.
     */
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * @param a Первый коэффициент.
     * @param b Второй коэффициент.
     * @param c Третий коэффициент.
     * @return Результатом метод возвращает строку, содержащую информацию о возможности или невозможности решения квадратного уравнения.
     */
    public static String quadraticEquation(double a, double b, double c) {
        String result = "";
        if (a != 0) {
            double res = Math.pow(b, 2) - 4 * a * c;
            if (res > 0) {
                double x1 = (-b - Math.pow(res, 0.5)) / (2 * a);
                double x2 = (-b + Math.pow(res, 0.5)) / (2 * a);
                result += "Два корня: " + x1 + " и " + x2;
            } else if (res == 0) {
                double x = (-b) / (2 * a);
                if (x == -0) x = 0;
                result += "Один корень: " + x;
            } else if (res < 0) {
                result += "Действительные решения уравнения отсутствуют";
            }
        } else {
            throw new ArithmeticException("Коэффициент 'a' не может быть равным нулю!");
        }
        return result;
    }
}

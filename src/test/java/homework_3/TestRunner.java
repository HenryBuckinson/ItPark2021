package homework_3;

import org.junit.Assert;
import org.junit.Test;


public class TestRunner {

    @Test
    public void shouldCalculateFactorialOfFive() {
        System.out.print("Тестирование функции на расчёт 5!...");
        Assert.assertEquals(120, MainProgram.factorial(5));
        System.out.println(" Passed!");
    }

    @Test
    public void shouldCalculateFactorialOfZero() {
        System.out.print("Тестирование функции на расчёт 0!...");
        Assert.assertEquals(1, MainProgram.factorial(0));
        System.out.println(" Passed!");
    }

    @Test
    public void shouldCalculateEquation() {
        System.out.print("Тестирование квадратного уравнения на отсутствие действительных решений...");
        Assert.assertEquals("Действительные решения уравнения отсутствуют", MainProgram.quadraticEquation(4, 0, 8));
        System.out.println(" Passed!");
    }

    @Test
    public void shouldCalculateEquationWithOneSolution() {
        System.out.print("Тестирование квадратного уравнения на наличие одного корня...");
        double root = 3;
        Assert.assertEquals("Один корень: " + root, MainProgram.quadraticEquation(3, -18, 27));
        System.out.println(" Passed!");
    }

    @Test
    public void shouldCalculateEquationWithTwoSolutions() {
        System.out.print("Тестирование квадратного уравнения на наличие корней...");
        double root1 = -7;
        double root2 = 1;
        Assert.assertEquals("Два корня: " + root1 + " и " + root2, MainProgram.quadraticEquation(1, 6, -7));
        System.out.println(" Passed!");
    }

    @Test(expected = ArithmeticException.class)
    public void shouldCalculateEquationIncorrectInput() {
        System.out.print("Тестирование квадратного уравнения на отсутствие старшего коэффициента...");
        MainProgram.quadraticEquation(0,5,-25);
        System.out.println(" Passed!");
    }
}

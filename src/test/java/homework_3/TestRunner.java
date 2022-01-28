package homework_3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class TestRunner {

    @Test
    @DisplayName("Тестирование функции на расчёт 5!")
    public void shouldCalculateFactorialOfFive() {
        Assert.assertEquals(120, MainProgram.factorial(5));
    }

    @Test
    @DisplayName("Тестирование функции на расчёт 0!")
    public void shouldCalculateFactorialOfZero() {
        Assert.assertEquals(1, MainProgram.factorial(0));
    }

    @Test
    @DisplayName("Тестирование квадратного уравнения на отсутствие действительных решений")
    public void shouldCalculateEquation() {
        Assert.assertEquals("Действительные решения уравнения отсутствуют", MainProgram.quadraticEquation(4, 0, 8));
    }

    @Test
    @DisplayName("Тестирование квадратного уравнения на наличие одного корня")
    public void shouldCalculateEquationWithOneSolution() {
        double root = 3;
        Assert.assertEquals("Один корень: " + root, MainProgram.quadraticEquation(3, -18, 27));
    }

    @Test
    @DisplayName("Тестирование квадратного уравнения на наличие корней")
    public void shouldCalculateEquationWithTwoSolutions() {
        double root1 = -7;
        double root2 = 1;
        Assert.assertEquals("Два корня: " + root1 + " и " + root2, MainProgram.quadraticEquation(1, 6, -7));
    }

    @Test(expected = ArithmeticException.class)
    @DisplayName("Тестирование квадратного уравнения на отсутствие старшего коэффициента")
    public void shouldCalculateEquationIncorrectInput() {
        MainProgram.quadraticEquation(0,5,-25);
    }
}

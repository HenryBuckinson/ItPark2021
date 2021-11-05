package Homework_2;

public class MainProgram {

    public static void main(String[] args) {
        System.out.println("Площадь круга = "+areaCircle(4));
        System.out.println("Плотность тела = "+bodyDensity(3.5,0.238));
    }

    /**
     * @param radius  радиус круга.
     * @return Результатом метод возвращает значение площади круга, округлённого до двух знаков после запятой.
     */
    public static double areaCircle(double radius) {
            if (radius > 0) {
                double scale = Math.pow(10, 2);
                return Math.ceil(Math.pow(radius, 2) * Math.PI * scale) / scale;
            }else throw new ArithmeticException("Радиус должен быть больше нуля!");}

    /**
     * @param mass масса тела.
     * @param capacity объем тела.
     * @return Результатом метод возвращает значение плотности тела, округлённого до двух знаков после запятой.
     * Входные параметры необходимо задавать в соответствии с системой СИ.
     */
    public static double bodyDensity(double mass, double capacity){
        if(mass>0 && capacity>0){
            double scale = Math.pow(10, 2);
            return Math.ceil(mass/capacity*scale)/scale;
        }else throw new ArithmeticException("Неверно введены аргументы метода");
    }
}

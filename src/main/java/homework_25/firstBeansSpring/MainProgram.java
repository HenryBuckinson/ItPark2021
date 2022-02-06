package homework_25.firstBeansSpring;

import homework_10.Temperature;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProgram {
    public static void main(String[] args) {

        System.out.println("Создан bean для класса(record'а) \"Temperature\" в homework_10:");
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("homework_24-25_files\\spring-context.xml");
        Temperature temperature = (Temperature) context1.getBean("boilingWater");
        temperature.displayTemperature();
        temperature.convertToCalvin().displayTemperature();
        temperature.convertToFahrenheit().displayTemperature();
        System.out.println();
        System.out.println("Создан bean для класса \"MainProgram\" в homework_3:");
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("homework_24-25_files\\spring-context.xml");
        System.out.println("5! = " + context2.getBean("factorial"));


    }
}

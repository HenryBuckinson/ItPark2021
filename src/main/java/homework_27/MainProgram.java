package homework_27;

import homework_27.config.AppConfig;
import homework_27.interfaces.PrototypePrinter;
import homework_27.interfaces.SingletonPrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProgram {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonPrinter bean1 = annotationContext.getBean(SingletonPrinter.class);
        PrototypePrinter bean2 = annotationContext.getBean(PrototypePrinter.class);

        System.out.println("Сводка по бину bean1:");
        bean1.singletonPrint();
        bean1.advancePrint().prototypePrint();

        System.out.println();

        System.out.println("Сводка по бину bean2:");
        bean2.prototypePrint();

        System.out.println();

        System.out.println(bean1.hashCode());
        System.out.println(bean2.hashCode());
        System.out.println("The end");
    }
}

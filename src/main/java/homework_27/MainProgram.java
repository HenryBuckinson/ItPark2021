package homework_27;

import homework_27.config.AppConfig;
import homework_27.interfaces.PrototypePrinter;
import homework_27.interfaces.SingletonPrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProgram {
    public static void main(String[] args) {
        System.out.println();
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonPrinter singleBean1 = annotationContext.getBean(SingletonPrinter.class);
        SingletonPrinter singleBean11 = annotationContext.getBean(SingletonPrinter.class);
        SingletonPrinter singleBean111 = annotationContext.getBean(SingletonPrinter.class);

        PrototypePrinter prototypeBean2 = annotationContext.getBean(PrototypePrinter.class);
        PrototypePrinter prototypeBean22 = annotationContext.getBean(PrototypePrinter.class);
        PrototypePrinter prototypeBean222 = annotationContext.getBean(PrototypePrinter.class);

        singleBean1.singletonPrint();
        singleBean1.advancePrint();

        singleBean11.singletonPrint();
        singleBean11.advancePrint();

        singleBean111.singletonPrint();
        singleBean111.advancePrint();

        System.out.println();


        prototypeBean2.prototypePrint();
        prototypeBean22.prototypePrint();
        prototypeBean222.prototypePrint();

        
    }
}

package homework_26;

import homework_26.base.CurrencyServiceImpl;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainProgram {

    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("homework_26");
        CurrencyServiceImpl bean = annotationContext.getBean(CurrencyServiceImpl.class);
        bean.getRubInfoRelateTo("USD");
        bean.getRubInfoRelateTo("KZT");
    }
}

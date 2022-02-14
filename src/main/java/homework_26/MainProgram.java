package homework_26;

import homework_26.base.Gettable;
import homework_26.mapper.Cacheable;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainProgram {

    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("homework_26");
        Cacheable bean = annotationContext.getBean(Cacheable.class);
        bean.CacheDataFromAPI("https://www.cbr-xml-daily.ru/daily_json.js");
        Gettable bean1 = annotationContext.getBean(Gettable.class);
        bean1.getRubInfoRelateTo("USD");
        bean1.getRubInfoRelateTo("AUD");


    }
}

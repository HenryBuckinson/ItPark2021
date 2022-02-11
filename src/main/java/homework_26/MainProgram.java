package homework_26;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework_26.base.CashValutes;
import homework_26.base.Gettable;
import homework_26.mapper.Request;
import homework_26.mapper.RequestTest;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class MainProgram {

    public static LinkedHashMap<String, Object> requestFromServer;

    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("homework_26");
        MainProgram bean1 = annotationContext.getBean(MainProgram.class);
        bean1.getValutesFrom("https://www.cbr-xml-daily.ru/daily_json.js");
        CashValutes bean2 = annotationContext.getBean(CashValutes.class);
        bean2.setValutes(requestFromServer);
        bean2.getValute("USD");


//        MainProgram mainObj = new MainProgram();
//        mainObj.getValutesFromTesting("https://www.cbr-xml-daily.ru/daily_json.js");
    }

    @SneakyThrows
    private void getValutesFrom(String url) {
        URL currencyUrl = new URL(url);
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Request currency = mapper.readValue(is, Request.class);
            LinkedHashMap<String, Object> valute = currency.getValute();
            requestFromServer = valute;
        }
    }

    @SneakyThrows
    private void getValutesFromTesting(String url) {
        URL currencyUrl = new URL(url);
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            RequestTest currency = mapper.readValue(is, RequestTest.class);
            LinkedHashMap<String, Collection<RequestTest.PrimaryInfo>> valute = currency.getValute();//AddInfo тут равен null
            System.out.println("THe end?");
        }
    }
}

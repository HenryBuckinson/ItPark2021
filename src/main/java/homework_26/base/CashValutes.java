package homework_26.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class CashValutes implements Gettable {

    @Getter
    @Setter
    private LinkedHashMap<String, Object> valutes;

    @Override
    public void getValute(String valute) {
        for (Map.Entry<String, Object> element : valutes.entrySet()) {
            if (element.getKey().equals(valute)) {
                LinkedHashMap<String, Object> value = (LinkedHashMap<String, Object>) element.getValue();
                System.out.println("Информация о валюте " + valute + " по отношению к RUB:");
                for (Map.Entry<String, Object> item : value.entrySet()) {
                    System.out.println(item);
                }
            }
        }
    }
}

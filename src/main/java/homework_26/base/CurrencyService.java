package homework_26.base;


import homework_26.mapper.Request;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@RequiredArgsConstructor
public class CurrencyService implements Gettable {

    private final Request request;

    @Override
    public void getRubInfoRelateTo(String valute) {
        for (Map.Entry<String, Request.Valute> element : request.getAllCurrency().entrySet()) {
            if (element.getKey().equals(valute)) {
                Request.Valute value = element.getValue();
                System.out.println("Информация о валюте " + valute + " по отношению к RUB:");
                System.out.println("Уникальный идентификатор - " + value.getId() + "\n" +
                        "Наименоввание - " + value.getName() + "\n" +
                        "Значение - " + value.getValue());
                break;
            }
        }
    }
}

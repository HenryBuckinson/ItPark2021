package homework_26.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Request implements Cacheable {

    private Map<String, Valute> allCurrency;

    @SneakyThrows
    @Override
    public void CacheDataFromAPI(String url) {
        URL currencyUrl = new URL(url);
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Request requestTest = mapper.readValue(is, Request.class);
            Map<String, Request.Valute> valute = requestTest.getValute();
            if (valute != null) {
                this.allCurrency = valute;
                System.out.println("Информация по адресу: \"" + url +"\" получена успешно.");
            }
            else {
                System.out.println("no data");
            }
        }
    }

    @JsonProperty("Valute")
    @JsonIgnoreProperties(ignoreUnknown = true)     //без неё не заработает. Строки 17 и 13 зависимы. Why?
    private Map<String, Valute> valute = new LinkedHashMap<>();

    @Data
    public static class Valute {

        @JsonProperty("ID")
        private String id;
        @JsonProperty("Name")
        private String name;
        @JsonProperty("Value")
        private Double value;

    }
}
package homework_22;

import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;


public class MainProgram {

    private static final String API_KEY = "6f7b7e7096b3b06794d1c0b50cdc294f";

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println();
        String city = "Zelenodolsk";
        getWeatherInfo(city);

    }

    public static void getWeatherInfo(String city) {
        JSONObject json = readJsonFromUrl("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric&ml");
//        System.out.println(json);
        JSONObject inner = json.getJSONObject("main");
//        System.out.println(inner);
        Map<String, Object> stringObjectMap = inner.toMap();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("Температура:", null);
        resultMap.put("Минимальная температура:", null);
        resultMap.put("Высота над ур.моря:", null);
        resultMap.put("Влажность:", null);
        resultMap.put("Давление:", null);
        resultMap.put("Уровень моря:", null);
        resultMap.put("Температура по ощущениям:", null);
        resultMap.put("Максимальная температура:", null);
        for (Map.Entry<String, Object> item : stringObjectMap.entrySet()) {
            for (Map.Entry<String, Object> element : resultMap.entrySet()) {
                if (element.getValue() == null) {
                    element.setValue(item.getValue());
                    break;
                }
            }
        }
        System.out.println("Информация о погоде в городе " + city + " на " + LocalDate.now() + ":");
        for (Map.Entry<String, Object> item : resultMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    @SneakyThrows
    private static String readAll(Reader rd) {
        StringBuilder strBuilder = new StringBuilder();
        int k;
        while ((k = rd.read()) != -1) {
            strBuilder.append((char) k);
        }
        return strBuilder.toString();
    }

    @SneakyThrows
    public static JSONObject readJsonFromUrl(String url) {
        InputStream is = new URL(url).openStream();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }
}


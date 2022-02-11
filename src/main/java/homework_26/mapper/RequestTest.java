package homework_26.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTest {

    @JsonProperty("Valute")
    private LinkedHashMap<String, Collection<PrimaryInfo>> valute;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PrimaryInfo {

        @JsonProperty
        private LinkedHashMap<PrimaryInfo, Class<SecondaryInfo>> addInfo;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SecondaryInfo {
            @JsonProperty("ID")
            private String id;
            @JsonProperty("Name")
            private String name;
            @JsonProperty("Value")
            private Double value;
        }

    }

}

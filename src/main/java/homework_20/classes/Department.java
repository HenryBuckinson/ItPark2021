package homework_20.classes;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "department")
@Data
public class Department {
    private String division;
    private String city;
}

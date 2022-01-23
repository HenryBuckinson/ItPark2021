package homework_20.classes;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@ToString
@XmlRootElement(name = "employee")
public class Employee {

    @XmlAttribute
    private int id;
    @XmlAttribute
    private String login;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String surname;
    private Department department;
    private Position position;

}

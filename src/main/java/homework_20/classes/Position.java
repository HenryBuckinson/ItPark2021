package homework_20.classes;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "position")
@Data
public class Position {
    private String crewSkill;
    private int salary;
}

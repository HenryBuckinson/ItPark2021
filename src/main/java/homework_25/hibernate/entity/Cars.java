package homework_25.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "Cars")
@NoArgsConstructor
@ToString
public class Cars {

    @Id
    private String id;
    @Column(name = "Mark")
    private String mark;
    @Column(name = "Model")
    private String model;
    @Column(name = "Year")
    private String year;

}

package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people")
@Data
public class TestPersonForSoftwareComplexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String address;
    private Long phoneNumber;
    private String email;

}
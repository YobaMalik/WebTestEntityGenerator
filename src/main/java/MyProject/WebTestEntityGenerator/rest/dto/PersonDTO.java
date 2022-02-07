package MyProject.WebTestEntityGenerator.rest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {
    private Short quantity;
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String address;
    private String phoneNumber;
    private String email;
}

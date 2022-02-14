package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SecurityTable")
@Data
public class AuthorisationUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String role;
    private String password;

}

package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SecurityTable")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private char[] password;

}

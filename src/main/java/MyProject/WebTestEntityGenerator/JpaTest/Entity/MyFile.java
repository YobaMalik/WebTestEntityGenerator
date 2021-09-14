package MyProject.WebTestEntityGenerator.JpaTest.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "raid1")
public class MyFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Column(name = "name")
    @Getter @Setter
    private String fileName;

}

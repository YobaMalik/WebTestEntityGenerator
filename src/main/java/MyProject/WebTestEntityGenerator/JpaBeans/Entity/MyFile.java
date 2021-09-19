package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "raid1")
@Getter
@Setter
@EqualsAndHashCode
public class MyFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "size")
    private Long size;

    @Column(name = "lastModified")
    private Long lastModified;


    //@Column (name = "fileBytes")
   // private File file;
}

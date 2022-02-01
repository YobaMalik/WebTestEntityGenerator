package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "raidtest")
@Data
public class MyFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "filePath" , columnDefinition = "varchar(1024)")
    private String filePath;

    @Column(name = "size")
    private Long size;

    @Column(name = "lastModified")
    private Long lastModified;

    @Column (name = "fileMask")
    private String fileMask;

    @OneToOne (cascade =  CascadeType.ALL)
    @MapsId
    private ImageInfo imageInfo;
}

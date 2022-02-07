package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "raid")
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
    private ImageInfo imageInfo;
}

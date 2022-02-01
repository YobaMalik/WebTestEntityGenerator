package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "imageStorage")
public class StorageEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "fileName")
    private String fileName;

    @Lob
    @Column (name = "byteArray")
    private byte[] byteArray;

    @OneToOne (cascade =  CascadeType.ALL)
    @MapsId
    private ImageInfo imageInfo;
}

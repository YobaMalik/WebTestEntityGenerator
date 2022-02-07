package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "storage_entity")
public class StorageEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "fileName")
    private String fileName;

    @Lob
    @Column (name = "byteArray")
    private byte[] byteArray;

    @OneToOne (cascade =  CascadeType.ALL)
    private StorageEntityInfo storageEntityInfo;


}

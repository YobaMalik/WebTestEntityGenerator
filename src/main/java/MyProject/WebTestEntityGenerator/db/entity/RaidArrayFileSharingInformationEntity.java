package MyProject.WebTestEntityGenerator.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Storage_entity_info")
public class RaidArrayFileSharingInformationEntity {


    public RaidArrayFileSharingInformationEntity() {

    }

    public RaidArrayFileSharingInformationEntity(String status, LocalDate localDate, String commentary) {
        this.status = status;
        this.localDate = localDate;
        this.commentary = commentary;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String status;

    private LocalDate localDate;

    private String commentary;
}



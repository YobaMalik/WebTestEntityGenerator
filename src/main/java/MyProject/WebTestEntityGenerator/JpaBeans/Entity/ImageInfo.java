package MyProject.WebTestEntityGenerator.JpaBeans.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ImageInfo")
@Data
public class ImageInfo {

    public ImageInfo(){

    }

    public ImageInfo(String status, LocalDate localDate, String commentary){
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

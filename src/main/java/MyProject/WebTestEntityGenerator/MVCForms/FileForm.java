package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FileForm {
    private Long pictureId;
    private String bytes;
    private String status;
    private LocalDate localDate;
    private String locationInfo;
}
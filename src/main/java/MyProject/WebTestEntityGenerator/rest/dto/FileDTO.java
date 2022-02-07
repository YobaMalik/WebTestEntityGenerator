package MyProject.WebTestEntityGenerator.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FileDTO {
    private Long pictureId;
    private String bytes;
    private String status;
    private LocalDate localDate;
    private String locationInfo;
}
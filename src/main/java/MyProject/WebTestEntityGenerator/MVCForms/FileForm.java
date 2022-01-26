package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Data;

@Data
public class FileForm {
    private Long pictureId;
    private byte[] bytes;
    private String status;
}

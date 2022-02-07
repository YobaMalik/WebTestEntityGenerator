package MyProject.WebTestEntityGenerator.rest.mvcforms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponsePostStatus {
    private String responseInfo;
    private Long id;
    private LocalDate localDate;
}

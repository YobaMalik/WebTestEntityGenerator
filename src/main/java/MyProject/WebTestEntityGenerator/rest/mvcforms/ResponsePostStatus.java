package MyProject.WebTestEntityGenerator.rest.mvcforms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponsePostStatus {

    private String responseInfo;
    private Long id;
    private LocalDate localDate;

    public ResponsePostStatus(String responseInfo, Long id) {
        this.responseInfo = responseInfo;
        this.id = id;
    }

    public ResponsePostStatus() {
    }

}

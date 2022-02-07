package MyProject.WebTestEntityGenerator.rest.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class StorageEntityDTO {

    private Long id;
    private String fileName;
    private String responseStatus;

    public StorageEntityDTO(){

    }

    public StorageEntityDTO(Long id, String responseStatus) {
        this.id = id;
        this.responseStatus = responseStatus;
    }
}

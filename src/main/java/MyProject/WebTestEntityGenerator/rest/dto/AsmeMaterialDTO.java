package MyProject.WebTestEntityGenerator.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsmeMaterialDTO {
    private Long id;
    private String nominalComposition;
    private String spec;
    private String grade;
    private String uns;
}

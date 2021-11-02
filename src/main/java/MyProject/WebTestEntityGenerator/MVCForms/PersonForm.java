package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonForm {

    private String message;
    private String phone;
    private Short quantity;

}

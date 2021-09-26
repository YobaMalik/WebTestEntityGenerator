package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("session")
public class PersonForm {

    @Getter @Setter private String message;
    @Getter @Setter private String phone;

}

package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("session")
@ToString
public class PersonForm {

    @Getter @Setter private String message;
    @Getter @Setter private String phone;

}

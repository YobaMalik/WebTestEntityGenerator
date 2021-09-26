package MyProject.WebTestEntityGenerator.MVCForms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@ToString
public class RegistrationForm {

    @Getter @Setter private String password;
    @Getter @Setter private String userName;

}

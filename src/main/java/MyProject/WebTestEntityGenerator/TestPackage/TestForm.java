package MyProject.WebTestEntityGenerator.TestPackage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class TestForm {
    @Getter @Setter private String message;

}

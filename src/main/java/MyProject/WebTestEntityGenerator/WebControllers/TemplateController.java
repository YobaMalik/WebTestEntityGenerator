package MyProject.WebTestEntityGenerator.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping(value = "/TestPage")
    public String getTestPage(){
        return "TestPage";
    }

}

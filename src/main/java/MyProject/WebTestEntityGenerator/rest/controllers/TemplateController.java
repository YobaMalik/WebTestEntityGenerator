package MyProject.WebTestEntityGenerator.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Deprecated
public class TemplateController {

    @GetMapping(value = "/TestPage")
    public String getTestPage(){
        return "TestPage";
    }

}

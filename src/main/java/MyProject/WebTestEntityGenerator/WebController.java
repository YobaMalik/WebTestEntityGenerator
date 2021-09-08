package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@Scope("session")
public class WebController {

    @Autowired
    EntityFactory entityFactory;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(HttpSession session, Principal principal, Model model) throws IOException {
        System.out.println(principal);
        return "index";
    }

    @PostMapping(path="test123", headers = {"Content-type=application/json"})
    @ResponseBody
    public Person getPerson(){
        return entityFactory.newInstanse();
    }

    @PostMapping(path="test", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Person> getPersonList(){
        return entityFactory.newInstanse(100);
    }
}

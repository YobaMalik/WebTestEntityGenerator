package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.Person;
import MyProject.WebTestEntityGenerator.JpaTest.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaTest.Service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private MyFileService myFileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(HttpSession session, Principal principal, Model model) {
        System.out.println(principal);
        return "index";
    }

    @PostMapping(value = "/test123", headers = {"Content-type=application/json"})
    @ResponseBody
    public Person getPerson() {
        return entityFactory.newInstanse();
    }

    @PostMapping(value = "/test", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Person> getPersonList() {
        return entityFactory.newInstanse(100);
    }

   @PostMapping(value = "/getMaxId", headers = {"Content-type=application/json"})
    @ResponseBody
    public void getMaxId() {
        List<MyFile> wtf = myFileService.findAll();
        wtf.forEach(System.out::println);
        System.out.println("zaebalo" +    wtf.size());
    }

}




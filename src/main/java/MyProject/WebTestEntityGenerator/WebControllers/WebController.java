package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private MyFileService myFileService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(HttpSession session, Principal principal, Model model) {
        System.out.println(principal);
        return "index";
    }

    @PostMapping(value = "/getOnePerson", headers = {"Content-type=application/json"})
    @ResponseBody
    public Person getPerson() {
        return peopleService.getFactory().newInstanse();
    }

    @PostMapping(value = "/getAllFromDB", headers = {"Content-type=application/json"})
    @ResponseBody
    public Iterable<Person> getPersonList() {
      //  System.out.println(peopleService.getAllEntites().getClass());
        return peopleService.getAllEntites();
    }

    @PostMapping(value = "/getMaxId", headers = {"Content-type=application/json"})
    @ResponseBody
    public String getMaxId() {
        peopleService.addPeople((short) 152);
        return "created 152 yebka";
    }
}




package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.Form;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.PeopleService;
import MyProject.WebTestEntityGenerator.TestPackage.TestForm;
import MyProject.WebTestEntityGenerator.ThreadTest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
public class RersonController {

    private PeopleService peopleService;

    @Autowired
    public RersonController(PeopleService peopleService){
        this.peopleService = peopleService;
    }



    @PostMapping(value = "/GetOnePerson", headers = {"Content-type=application/json"})
    @ResponseBody
    public Person getPerson() {
        return peopleService.getFactory().newInstanse();
    }

    @PostMapping(value = "/GetAllFromDB", headers = {"Content-type=application/json"})
    @ResponseBody
    public Iterable<Person> getPersonList() {
        return peopleService.getAllEntities();
    }

    @PostMapping(value = "/GetMaxId"/*, headers = {"Content-type=application/json"}*/)
    @ResponseBody
    public void getMaxId() {
        peopleService.addPeople((short) 152);
    }

    @PostMapping(value = "/FindByContaining", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Person> findByContaining(@RequestBody TestForm message) {
        return peopleService.findByLastNameContaining(message.getMessage());
    }

    @PostMapping(value = "/UpdateTest", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateTest(@RequestBody TestForm message) {
        peopleService.updateEntity(1L,message.getMessage());
    }

}




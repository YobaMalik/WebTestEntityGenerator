package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.CacheData;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.PeopleService;
import MyProject.WebTestEntityGenerator.MVCForms.PersonForm;
import MyProject.WebTestEntityGenerator.ThreadTest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@SessionScope
public class RersonController {

    private CacheData data;
    private PeopleService peopleService;

    @Autowired
    public RersonController(PeopleService peopleService, CacheData data){
        this.peopleService = peopleService;
        this.data = data;
    }

    @PostMapping(value = "GetOnePerson", headers = {"Content-type=application/json"})
    @ResponseBody
    public Person getPerson() {
        return peopleService.getFactory().newInstanse();
    }

    @PostMapping(value = "GetAllFromDB", headers = {"Content-type=application/json"})
    @ResponseBody
    public Iterable<Person> getPersonList() {
        return peopleService.getAllEntities();
    }

    @PostMapping(value = "CreatePeopleInfo", headers = {"Content-type=application/json"})
    @ResponseBody
    public void getMaxId(@RequestBody PersonForm form) {
      peopleService.addPeople(form.getQuantity());
    }

    @PostMapping(value = "FindByContaining", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Person> findByContaining(@RequestBody PersonForm message) {
       return peopleService.findAll(data.getLatNameContaining(message.getMessage()));
       //  return peopleService.findByLastNameContaining(message.getMessage());
    }

    @PostMapping(value = "UpdateEntity", headers = {"Content-type=application/json"})
 //   @ResponseBody
    public void updateEntity(@RequestBody PersonForm message) {
        peopleService.updateEntity(1L,message.getMessage());
    }

    @PostMapping(value = "UpdateEntityTest", headers = {"Content-type=application/json"})
//    @ResponseBody
    public void updateEntityTest(@RequestBody Person person) {
        System.out.println(person);
    }

}




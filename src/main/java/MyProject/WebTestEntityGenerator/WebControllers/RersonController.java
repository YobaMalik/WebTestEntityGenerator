package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.CacheData;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.PeopleService;
import MyProject.WebTestEntityGenerator.MVCForms.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RersonController {

    @Autowired
    private CacheData data;

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
    public List<Person> findByContaining(@RequestBody PersonForm message) {
       return peopleService.findAll(data.getLatNameContaining(message.getMessage()));
       //  return peopleService.findByLastNameContaining(message.getMessage());
    }

    @PostMapping(value = "/UpdateEntity", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateEntity(@RequestBody PersonForm message) {
        peopleService.updateEntity(1L,message.getMessage());
    }

}




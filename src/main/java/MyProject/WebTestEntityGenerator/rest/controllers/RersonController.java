package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.db.entity.Person;
import MyProject.WebTestEntityGenerator.rest.dto.PersonDTO;
import MyProject.WebTestEntityGenerator.services.PeopleService;
import MyProject.WebTestEntityGenerator.util.entityhandler.PersonDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@SessionScope
public class RersonController {

    private PeopleService peopleService;

    @Autowired
    public RersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping(value = "GetOnePerson", headers = {"Content-type=application/json"})
    @ResponseBody
    public PersonDTO getPerson() {
        return peopleService.getOnePerson();
    }

    @PostMapping(value = "GetAllFromDB", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<PersonDTO> getPersonList() {
        return peopleService.getAllEntities();
    }

    @PostMapping(value = "CreatePeopleInfo", headers = {"Content-type=application/json"})
    @ResponseBody
    public void getMaxId(@RequestBody PersonDTO personDTO) {
        peopleService.addPeople(personDTO);
    }

    @PostMapping(value = "FindByContaining", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<Person> findByContaining(@RequestBody PersonDTO personDTO) {
        return peopleService.findByLastNameContaining(personDTO);
    }

    @PostMapping(value = "UpdateEntity", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateEntity(@RequestBody PersonDTO personDTO) {
        peopleService.updateEntity(personDTO);
    }

    @PostMapping(value = "UpdateEntityTest", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateEntityTest(@RequestBody PersonDTO personDTO) {
        System.out.println(personDTO);
    }

}




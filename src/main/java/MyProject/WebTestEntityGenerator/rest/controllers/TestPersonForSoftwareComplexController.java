package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.db.entity.TestPersonForSoftwareComplexEntity;
import MyProject.WebTestEntityGenerator.rest.dto.PersonDTO;
import MyProject.WebTestEntityGenerator.services.TestPersonForSoftwareComplexService;
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
public class TestPersonForSoftwareComplexController {

    private TestPersonForSoftwareComplexService testPersonForSoftwareComplexService;

    @Autowired
    public TestPersonForSoftwareComplexController(TestPersonForSoftwareComplexService testPersonForSoftwareComplexService) {
        this.testPersonForSoftwareComplexService = testPersonForSoftwareComplexService;
    }

    @PostMapping(value = "GetOnePerson", headers = {"Content-type=application/json"})
    @ResponseBody
    public PersonDTO getPerson() {
        return testPersonForSoftwareComplexService.getOnePerson();
    }

    @PostMapping(value = "GetAllFromDB", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<PersonDTO> getPersonList() {
        return testPersonForSoftwareComplexService.getAllEntities();
    }

    @PostMapping(value = "CreatePeopleInfo", headers = {"Content-type=application/json"})
    @ResponseBody
    public void getMaxId(@RequestBody PersonDTO personDTO) {
        testPersonForSoftwareComplexService.addPeople(personDTO);
    }

    @PostMapping(value = "FindByContaining", headers = {"Content-type=application/json"})
    @ResponseBody
    public List<TestPersonForSoftwareComplexEntity> findByContaining(@RequestBody PersonDTO personDTO) {
        return testPersonForSoftwareComplexService.findByLastNameContaining(personDTO);
    }

    @PostMapping(value = "UpdateEntity", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateEntity(@RequestBody PersonDTO personDTO) {
        testPersonForSoftwareComplexService.updateEntity(personDTO);
    }

    @PostMapping(value = "UpdateEntityTest", headers = {"Content-type=application/json"})
    @ResponseBody
    public void updateEntityTest(@RequestBody PersonDTO personDTO) {
        System.out.println(personDTO);
    }

}




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
public class WebController {

    @Autowired
    private FileSearchThread thread;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private MyFileService myFileService;

    @Autowired
    private TestForm testForm;

    @Autowired
    private Form form;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        form.setMyFileMap(myFileService.findAll());
        model.addAttribute("form", form);
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
        return peopleService.getAllEntities();
    }

    @PostMapping(value = "/getMaxId"/*, headers = {"Content-type=application/json"}*/)
    @ResponseBody
    public void getMaxId() {
        peopleService.addPeople((short) 152);
    }

    @PostMapping(value = "/onсhangeTest", headers = {"Content-type=application/json"})
    @ResponseBody
    public Iterable<Person> getNewValue(@RequestBody TestForm message) {
        return StreamSupport.stream(
                peopleService.getAllEntities().spliterator(),false)
                .filter(e -> e.getFirstName().contains(message.getMessage()))
                .collect(Collectors.toList()
                );
    }
}




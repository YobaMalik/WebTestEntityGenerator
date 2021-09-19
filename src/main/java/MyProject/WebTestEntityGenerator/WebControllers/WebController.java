package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.Form;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.PeopleService;
import MyProject.WebTestEntityGenerator.ThreadTest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.ServerResponse;

@Controller
public class WebController {

    @Autowired
    private FileSearchThread thread;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private MyFileService myFileService;

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
      //  System.out.println(peopleService.getAllEntites().getClass());
        thread.run();
        return peopleService.getAllEntites();
    }

    @PostMapping(value = "/getMaxId"/*, headers = {"Content-type=application/json"}*/)
    @ResponseBody
    public void getMaxId() {
     //   response.setStatusCode(HttpStatus.BAD_REQUEST);
        peopleService.addPeople((short) 152);
    }

}




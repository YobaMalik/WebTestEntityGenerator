package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.JpaBeans.Service.UserService;
import MyProject.WebTestEntityGenerator.MVCForms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    //
    private RegistrationForm registrationForm;
    private UserService userService;

    @Autowired
    public RegistrationController(RegistrationForm registrationForm, UserService userService) {
        this.registrationForm = registrationForm;
        this.userService = userService;
    }

    @GetMapping( value = "reg")
    public String getRegistrationPage(Model model){
 //       model.addAttribute("registrationForm",registrationForm);
        return "SomePage";
    }

    @PostMapping(path = "zulul", headers = "Content-type=application/json")
    @ResponseBody
    public String registration( @RequestBody RegistrationForm form){
        userService.registration(form);
        return "redirect:/";
    }

}

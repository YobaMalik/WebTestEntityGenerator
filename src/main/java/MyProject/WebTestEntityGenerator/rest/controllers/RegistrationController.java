package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.services.UserService;
import MyProject.WebTestEntityGenerator.rest.mvcforms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "reg")
    public String getRegistrationPage(Model model) {
        //       model.addAttribute("registrationForm",registrationForm);
        return "SomePage";
    }

    @PostMapping(path = "zulul", headers = "Content-type=application/json")
//    @ResponseBody
    public String registration(@RequestBody RegistrationForm form) {
        userService.registration(form);
        return "redirect:/";
    }

}

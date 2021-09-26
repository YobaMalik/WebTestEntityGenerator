package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.FileUploader;
import MyProject.WebTestEntityGenerator.MVCForms.FileExchangerForm;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import MyProject.WebTestEntityGenerator.MVCForms.RegistrationForm;
import MyProject.WebTestEntityGenerator.ThreadTest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileExchangerController {

    private MyFileService myFileService;
    private FileUploader uploader;
    private FileExchangerForm form;
    private FileSearchThread thread;
    private RegistrationForm registrationForm;

    @Autowired
    public FileExchangerController(MyFileService myFileService,
                                   FileUploader uploader,
                                   FileExchangerForm form,
                                   FileSearchThread thread){
        this.uploader = uploader;
        this.form = form;
        this.myFileService = myFileService;
        this.thread = thread;
    }
    
    @PostMapping(value = "/SaveFiles")
    public String saveFiles(@ModelAttribute("form") FileExchangerForm form){
        myFileService.addFiles(form);
        return "redirect:/";
    }

    @PostMapping(value = "/UploadFiles")
    public void uploadFiles(HttpServletResponse response, @ModelAttribute("form") FileExchangerForm form){
       uploader.upload(form.getFilePath(),response);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        form.setMyFileMap(myFileService.findAll());
        model.addAttribute("form", form);
        model.addAttribute("registrationForm",registrationForm);
        return "index";
    }

}

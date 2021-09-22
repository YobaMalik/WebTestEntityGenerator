package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.FileUploader;
import MyProject.WebTestEntityGenerator.FileExchanger.Form;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileExchangerController {

    @Autowired
    private MyFileService myFileService;

    @Autowired
    private FileUploader uploader;

    @PostMapping(value = "/saveFiles")
    public String saveFiles(@ModelAttribute("form") Form form){
        myFileService.addFiles(form);
        return "redirect:/";
    }

    @PostMapping(value = "/uploadFiles")
    public void uploadFiles(HttpServletResponse response, @ModelAttribute("form") Form form){
        uploader.upload(form.getFilePath(),response);
    }

}

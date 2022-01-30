package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.FileExchanger.FileUploader;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.MyFileService;
import MyProject.WebTestEntityGenerator.MVCForms.FileExchangerForm;
import MyProject.WebTestEntityGenerator.MVCForms.FileForm;
import MyProject.WebTestEntityGenerator.MVCForms.RegistrationForm;
import MyProject.WebTestEntityGenerator.ThreadTest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Controller
@CrossOrigin(maxAge = 3600)
@SessionScope
public class FileExchangerController {

    private MyFileService myFileService;
    private FileConverter fileConverter;
    private FileExchangerForm form;
    private RegistrationForm registrationForm;

    @Autowired
    private FileSearchThread thread;

    @Autowired
    public FileExchangerController(MyFileService myFileService,
                                   FileConverter fileConverter,
                                   FileExchangerForm form){
        this.fileConverter = fileConverter;
        this.form = form;
        this.myFileService = myFileService;
    }
    
    @PostMapping(value = "/SaveFiles")
    public String saveFiles(@ModelAttribute("form") FileExchangerForm form){
        myFileService.addFiles(form);
        return "redirect:/";
    }

    @PostMapping(value = "/UploadFiles")
    public void uploadFiles(HttpServletResponse response, @ModelAttribute("form") FileExchangerForm form){
      // uploader.upload(form.getFilePath(),response);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        form.setMyFileMap(myFileService.findAll());
        model.addAttribute("form", form);
        model.addAttribute("registrationForm",registrationForm);
        return "index";
    }

    //Get one file by ID in DB
    @PostMapping (value = "GetOnePic", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public FileForm getOnePic(@RequestBody FileForm fileForm) throws IOException {
        MyFile myFile = myFileService.getPicById(fileForm.getPictureId());
        return fileConverter.convert(myFile);
    }

    @PostMapping (value = "UpdateFileInfo")
    @ResponseBody
    public void getFile(@RequestBody FileForm fileForm){
        myFileService.updateEntity(fileForm);
    }

}

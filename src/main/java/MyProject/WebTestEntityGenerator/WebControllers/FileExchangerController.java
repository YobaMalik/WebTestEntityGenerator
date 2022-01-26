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
import java.io.FileNotFoundException;

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
    public byte[] getOnePic(@RequestBody FileForm fileForm) {
        MyFile myFilemy = myFileService.getPicById(fileForm.getPictureId());
        //fileForm.setBytes(uploader.upload(myFileService.getFileById(fileForm.getPictureId())).toByteArray());
        return fileConverter.convert(myFilemy).getBytes();
    }
/*
    @PostMapping (value = "GetFile")
    @ResponseBody
    public byte[] getFile(@RequestBody FileForm fileForm){
        return uplo
    }Blob {size: 5219622, type: 'application/octet-stream'}
*/
}

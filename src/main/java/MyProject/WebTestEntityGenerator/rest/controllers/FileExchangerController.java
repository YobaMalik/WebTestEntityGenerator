package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.services.MyFileService;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import MyProject.WebTestEntityGenerator.util.threadtest.FileSearchThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.io.*;

@Controller
@CrossOrigin(maxAge = 3600)
@SessionScope
public class FileExchangerController {

    private MyFileService myFileService;

    @Autowired
    private FileSearchThread thread;

    @Autowired
    public FileExchangerController(MyFileService myFileService) {
        this.myFileService = myFileService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
      /*  form.setMyFileMap(myFileService.findAll());
        model.addAttribute("form", form);
        model.addAttribute("registrationForm", registrationForm);*/

       // myFileService.addFiles(thread.getFileMap());
     //   System.out.println("done");
        return "index";
    }

    //Get one file by ID in DB
    @PostMapping(value = "DownloadOneImage", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public FileDTO getOnePic(@RequestBody FileDTO fileForm) throws IOException {
        return myFileService.getPicById(fileForm);
    }

    @PostMapping(value = "UpdateImageInfo")
    @ResponseBody
    public void updateImageInfo(@RequestBody FileDTO fileForm) {
        myFileService.updateEntity(fileForm);
    }

}

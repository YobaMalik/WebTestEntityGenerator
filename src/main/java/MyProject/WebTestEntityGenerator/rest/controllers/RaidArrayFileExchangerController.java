package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.services.RaidArrayFileService;
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
public class RaidArrayFileExchangerController {

    private RaidArrayFileService raidArrayFileService;

    @Autowired
    private FileSearchThread thread;

    @Autowired
    public RaidArrayFileExchangerController(RaidArrayFileService raidArrayFileService) {
        this.raidArrayFileService = raidArrayFileService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
       // myFileService.addFiles(thread.getFileMap());
     //   System.out.println("done");
        return "index";
    }

    //Get one file by ID in DB
    @PostMapping(value = "DownloadOneFile", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public FileDTO getOnePic(@RequestBody FileDTO fileForm) throws IOException {
        return raidArrayFileService.getPicById(fileForm);
    }

    @PostMapping(value = "UpdateImageInfo")
    @ResponseBody
    public void updateImageInfo(@RequestBody FileDTO fileForm) {
        raidArrayFileService.updateEntity(fileForm);
    }

}

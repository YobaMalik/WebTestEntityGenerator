package MyProject.WebTestEntityGenerator.WebControllers;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.StorageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionScope
@CrossOrigin(maxAge = 3600)
public class ImageStorageController {

    private StorageEntityService entityService;
    private FileConverter fileConverter;

    public ImageStorageController(@Autowired StorageEntityService entityService){
        this.entityService = entityService;
    }

    @PostMapping(value = "SaveImage", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public void saveFile(@RequestParam(value = "file") MultipartFile multipartFile){
        entityService.saveToStorage(
                fileConverter.convertToStorageEntity(multipartFile));
    }
}

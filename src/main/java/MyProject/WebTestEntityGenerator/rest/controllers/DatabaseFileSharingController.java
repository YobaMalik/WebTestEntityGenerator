package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.rest.dto.StorageEntityDTO;
import MyProject.WebTestEntityGenerator.services.DatabaseFileSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@SessionScope
@CrossOrigin(maxAge = 3600)
public class DatabaseFileSharingController {

    private DatabaseFileSharing databaseFileSharing;

    public DatabaseFileSharingController(@Autowired DatabaseFileSharing databaseFileSharing) {
        this.databaseFileSharing = databaseFileSharing;
    }

    @PostMapping(value = "SaveImage", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public StorageEntityDTO saveFile(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        multipartFile.getResource();
        return databaseFileSharing.saveToStorage(multipartFile);
    }

//TODO Problem with send as response

    @PostMapping (value = "DownloadOneImage")
    @ResponseBody
    public ResponseEntity<Resource> downloadOneImage (@RequestBody StorageEntityDTO dto) throws IOException {

        MultipartFile multipartFile = databaseFileSharing.uploadOneImage(dto.getId());
        Resource fileSystemResource = multipartFile.getResource();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fileSystemResource);
    }
}

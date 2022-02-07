package MyProject.WebTestEntityGenerator.rest.controllers;

import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import MyProject.WebTestEntityGenerator.rest.dto.StorageEntityDTO;
import MyProject.WebTestEntityGenerator.services.StorageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
public class ImageStorageController {

    private StorageEntityService entityService;

    public ImageStorageController(@Autowired StorageEntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping(value = "SaveImage", headers = "Content-type=multipart/form-data")
    @ResponseBody
    public StorageEntityDTO saveFile(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        multipartFile.getResource();
        return entityService.saveToStorage(multipartFile);
    }

//TODO Problem with send as response
    @PostMapping (value = "UploadOneImage", headers = "Content-type=application/json")
    public ResponseEntity<Resource> uploadOneImage (@RequestBody StorageEntityDTO dto) throws IOException {
        MultipartFile multipartFile = entityService.uploadOneImage(dto.getId());
        Resource fileSystemResource = multipartFile.getResource();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileSystemResource);
    }
}

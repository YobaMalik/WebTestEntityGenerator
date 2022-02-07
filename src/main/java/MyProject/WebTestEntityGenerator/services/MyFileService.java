package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import MyProject.WebTestEntityGenerator.db.repository.FileRepository;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class MyFileService {

    private FileRepository fileRepository;
    private FileDTOConverter fileConverter;
    private FileDTOConverter converter;

    @Autowired
    public MyFileService(FileRepository fileRepository,
                         FileDTOConverter converter,
                         FileDTOConverter fileConverter) {
        this.fileConverter = fileConverter;
        this.converter = converter;
        this.fileRepository = fileRepository;
    }

    public Map<String, MyFile> findAll() {
        Map<String, MyFile> fileMap = new HashMap<>();
        fileRepository.findAll().forEach(e -> fileMap.putIfAbsent(e.getFilePath(), e));
        return fileMap;
    }

    public void addFile(MyFile myFile) {
        fileRepository.save(myFile);
    }

    public void addFiles(List<MyFile> files) {
        fileRepository.saveAll(files);
    }

    private List<MyFile> convertMockMultiPartFile(List<MultipartFile> files) {
        List<MyFile> myFileList = new ArrayList<>();
        files.forEach(e -> myFileList.add(converter.convert(e)));
        return myFileList;
    }

    public void findByPart() {
        fileRepository.findAll();
    }

    public FileDTO getPicById(FileDTO fileForm) throws IOException {
        Optional<MyFile> result = fileRepository.findById(fileForm.getPictureId());
        return converter.convert(result.orElse(new MyFile()));
    }

    public void updateEntity(FileDTO fileForm) {
        Optional<MyFile> myFile = fileRepository.findById(fileForm.getPictureId());
        if (myFile.isPresent()) {
            myFile.get().getImageInfo().setStatus(fileForm.getStatus());
            fileRepository.save(myFile.get());
        }
    }

}

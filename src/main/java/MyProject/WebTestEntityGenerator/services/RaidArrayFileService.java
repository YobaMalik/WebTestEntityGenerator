package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileEntity;
import MyProject.WebTestEntityGenerator.db.repository.RaidArrayFileRepository;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import MyProject.WebTestEntityGenerator.rest.mvcforms.ResponsePostStatus;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class RaidArrayFileService {

    private RaidArrayFileRepository raidArrayFileRepository;
    private FileDTOConverter converter;

    @Autowired
    public RaidArrayFileService(RaidArrayFileRepository fileRepository,
                                FileDTOConverter converter) {
        this.converter = converter;
        this.raidArrayFileRepository = fileRepository;
    }

    public Map<String, RaidArrayFileEntity> findAll() {
        Map<String, RaidArrayFileEntity> fileMap = new HashMap<>();
        raidArrayFileRepository.findAll().forEach(e -> fileMap.putIfAbsent(e.getFilePath(), e));
        return fileMap;
    }

    public void addFile(RaidArrayFileEntity myFile) {
        raidArrayFileRepository.save(myFile);
    }

    public void addFiles(List<RaidArrayFileEntity> files) {
        raidArrayFileRepository.saveAll(files);
    }

    private List<RaidArrayFileEntity> convertMockMultiPartFile(List<MultipartFile> files) {
        List<RaidArrayFileEntity> myFileList = new ArrayList<>();
        files.forEach(e -> myFileList.add(converter.convert(e)));
        return myFileList;
    }

    public void findByPart() {
        raidArrayFileRepository.findAll();
    }

    public FileDTO getPicById(FileDTO fileForm) throws IOException {
        Optional<RaidArrayFileEntity> result = raidArrayFileRepository.findById(fileForm.getPictureId());
        return converter.convert(result.orElse(new RaidArrayFileEntity()));
    }

    public ResponsePostStatus updateEntity(FileDTO fileForm) {
        Optional<RaidArrayFileEntity> raidArrayFileEntity = raidArrayFileRepository.findById(fileForm.getPictureId());
        if (raidArrayFileEntity.isPresent()) {
            RaidArrayFileEntity entity = raidArrayFileEntity.get();
            entity.getImageInfo().setStatus(fileForm.getStatus());
            raidArrayFileRepository.save(entity);
            return new ResponsePostStatus("success",entity.getId());
        } else {
            return new ResponsePostStatus("Failure",1L);
        }
    }
}

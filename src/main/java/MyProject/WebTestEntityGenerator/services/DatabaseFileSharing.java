package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.rest.dto.StorageEntityDTO;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import MyProject.WebTestEntityGenerator.db.entity.DatabaseFileSharingEntity;
import MyProject.WebTestEntityGenerator.db.repository.DatabaseFileSharingRepository;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DatabaseFileSharing {

    private DatabaseFileSharingRepository databaseFileSharingRepository;
    private FileDTOConverter fileConverter;

    @Autowired
    public DatabaseFileSharing(DatabaseFileSharingRepository databaseFileSharingRepository,
                               FileDTOConverter fileConverter) {
        this.databaseFileSharingRepository = databaseFileSharingRepository;
        this.fileConverter = fileConverter;
    }

    public StorageEntityDTO saveToStorage(MultipartFile multipartFile) throws IOException {
        DatabaseFileSharingEntity storageEntity = fileConverter.convertToStorageEntity(multipartFile);
        databaseFileSharingRepository.save(storageEntity);
        return new StorageEntityDTO(storageEntity.getId(), multipartFile.getOriginalFilename(), "success");
    }

    public Optional<DatabaseFileSharingEntity> findById(FileDTO fileForm) {
        return databaseFileSharingRepository.findById(fileForm.getPictureId());
    }

    public void deleteById(FileDTO fileForm) {
        databaseFileSharingRepository.deleteById(fileForm.getPictureId());
    }

    public void deleteByEntity(DatabaseFileSharingEntity storageEntity) {
        databaseFileSharingRepository.delete(storageEntity);
    }

    public MultipartFile uploadOneImage(Long id) throws IOException {
        Optional<DatabaseFileSharingEntity> myFile = databaseFileSharingRepository.findById(id);
        return fileConverter.convertToMultipartFile(myFile.get());
    }
}

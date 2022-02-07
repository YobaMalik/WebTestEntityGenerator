package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import MyProject.WebTestEntityGenerator.rest.dto.StorageEntityDTO;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import MyProject.WebTestEntityGenerator.db.entity.StorageEntity;
import MyProject.WebTestEntityGenerator.db.repository.StorageEntityRepository;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageEntityService {

    private StorageEntityRepository storageEntityRepository;
    private FileDTOConverter fileConverter;

    @Autowired
    public StorageEntityService(StorageEntityRepository storageEntityRepository,
                                FileDTOConverter fileConverter) {
        this.storageEntityRepository = storageEntityRepository;
        this.fileConverter = fileConverter;
    }

    public StorageEntityDTO saveToStorage(MultipartFile multipartFile) throws IOException {
        StorageEntity storageEntity = fileConverter.convertToStorageEntity(multipartFile);
        storageEntityRepository.save(storageEntity);
        System.out.println(storageEntity.getId());
        return new StorageEntityDTO(storageEntity.getId(),"success");
    }

    public Optional<StorageEntity> findById(FileDTO fileForm) {
        return storageEntityRepository.findById(fileForm.getPictureId());
    }

    public void deleteById(FileDTO fileForm) {
        storageEntityRepository.deleteById(fileForm.getPictureId());
    }

    public void deleteByEntity(StorageEntity storageEntity) {
        storageEntityRepository.delete(storageEntity);
    }

    public MultipartFile uploadOneImage(Long id) throws IOException {
        Optional<StorageEntity> myFile = storageEntityRepository.findById(id);
        return fileConverter.convertToMultipartFile(myFile.get());
    }
}

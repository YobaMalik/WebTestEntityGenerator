package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.StorageEntity;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.StorageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageEntityService {

    private StorageEntityRepository storageEntityRepository;

    @Autowired
    public StorageEntityService(StorageEntityRepository storageEntityRepository){
        this.storageEntityRepository = storageEntityRepository;
    }

    public void saveToStorage(StorageEntity storageEntity){
        storageEntityRepository.save(storageEntity);
    }

    public Optional<StorageEntity> findById(Long id){
        return storageEntityRepository.findById(id);
    }

    public void deletebyId(Long id){
        storageEntityRepository.deleteById(id);
    }

    public void deleteByEntity(StorageEntity storageEntity){
        storageEntityRepository.delete(storageEntity);
    }

}

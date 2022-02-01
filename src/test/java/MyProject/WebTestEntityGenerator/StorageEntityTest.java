package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.ImageInfo;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.StorageEntity;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.StorageEntityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StorageEntityTest {

    @Autowired
    private StorageEntityService service;

    @Autowired
    private FileConverter converter;

    @Test
    public void entitySaveTest(){
        service.saveToStorage(this.testImageEntity());
    }

    @Test
    public void entityDownloadTest(){
        Optional<StorageEntity> storageEntity = service.findById(41298L);
        Assertions.assertTrue(storageEntity.isPresent());

        StorageEntity entity = storageEntity.orElse(null);

        try(OutputStream out = new FileOutputStream("/mnt/1F1F7D497672B852" + File.separator + entity.getFileName());
            InputStream in = new ByteArrayInputStream(entity.getByteArray())){
            int count;
            byte[] bytes = new byte[8192];
            while((count = in.read(bytes)) != -1){
                out.write(bytes,0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StorageEntity testImageEntity(){
        StorageEntity entity = converter.convertToStorageEntity(new File("/media/yoba/wd120green/123.jpg"));

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        entity.setImageInfo(new ImageInfo("test",localDate,
                "file added at " + System.currentTimeMillis()));

        return entity;
    }
}

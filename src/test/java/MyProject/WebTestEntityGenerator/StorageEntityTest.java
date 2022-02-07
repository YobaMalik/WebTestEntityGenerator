package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.db.entity.StorageEntityInfo;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import MyProject.WebTestEntityGenerator.db.entity.ImageInfo;
import MyProject.WebTestEntityGenerator.db.entity.StorageEntity;
import MyProject.WebTestEntityGenerator.services.StorageEntityService;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

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
    private FileDTOConverter converter;

    @Test
    public void entitySaveTest() throws IOException {
        service.saveToStorage(this.testImageEntity());
    }

    @Test
    public void entityDownloadTest() {
        FileDTO testFileForm = new FileDTO();
        testFileForm.setPictureId(41298L);
        Optional<StorageEntity> storageEntity = service.findById(testFileForm);

        Assertions.assertTrue(storageEntity.isPresent());
/*
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

 */

    }

    public MultipartFile testImageEntity() {
        StorageEntity entity = converter.convertToStorageEntity(new File("/media/yoba/wd120green/123.jpg"));

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        entity.setStorageEntityInfo(new StorageEntityInfo("test", localDate,
                "file added at " + System.currentTimeMillis()));
        MultipartFile multipartFile = new MockMultipartFile(entity.getFileName(), entity.getByteArray());
        return multipartFile;
    }
}

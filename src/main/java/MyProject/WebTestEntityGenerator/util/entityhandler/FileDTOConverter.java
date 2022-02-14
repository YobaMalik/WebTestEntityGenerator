package MyProject.WebTestEntityGenerator.util.entityhandler;

import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileInformationEntity;
import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileEntity;
import MyProject.WebTestEntityGenerator.db.entity.DatabaseFileSharingEntity;
import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileSharingInformationEntity;
import MyProject.WebTestEntityGenerator.rest.MyMockMultipartFile;
import MyProject.WebTestEntityGenerator.rest.dto.FileDTO;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class FileDTOConverter {

    public RaidArrayFileEntity convert(File file)  {
        RaidArrayFileEntity myFile = new RaidArrayFileEntity();
        myFile.setFileName(file.getName());
        myFile.setFilePath(file.getPath());
        myFile.setSize(file.length());
        myFile.setLastModified(System.currentTimeMillis());
        myFile.setFileMask(getFileMask(file.getName()));

        LocalDate localDate = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate();


        myFile.setImageInfo(new RaidArrayFileInformationEntity());
        return myFile;
    }


    public FileDTO convert (RaidArrayFileEntity myFile) throws IOException {
        FileDTO fileDTO = new FileDTO();
        File file = new File(myFile.getFilePath());
        FileTime fileTime =
                Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime();
        LocalDate localDate = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        fileDTO.setBytes(
                Base64.encodeBase64String(
                        convertToByteArrayOS(new File(myFile.getFilePath())).toByteArray()
                )
        );

        String locationInfo = Arrays.stream(myFile.getFilePath().split("/"))
                .skip(3).limit(5).collect(Collectors.joining("/"));

        fileDTO.setLocationInfo(locationInfo);
        fileDTO.setLocalDate(localDate);
        fileDTO.setPictureId(myFile.getId());
        fileDTO.setStatus(myFile.getImageInfo().getStatus());

        return fileDTO;
    }

    public DatabaseFileSharingEntity convertToStorageEntity(MultipartFile multipartFile) throws IOException {
        DatabaseFileSharingEntity storageEntity = new DatabaseFileSharingEntity();
        storageEntity.setFileName(multipartFile.getOriginalFilename());
        storageEntity.setByteArray(multipartFile.getBytes());

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        storageEntity.setStorageEntityInfo(new RaidArrayFileSharingInformationEntity("Test File",localDate,
               "Upload at " + localDate.toString()));

        return storageEntity;
    }

    public DatabaseFileSharingEntity convertToStorageEntity(File file){
        DatabaseFileSharingEntity storageEntity = new DatabaseFileSharingEntity();
        storageEntity.setByteArray(this.convertToByteArrayOS(file).toByteArray());
        storageEntity.setFileName(file.getName());
        return storageEntity;
    }
    private ByteArrayOutputStream convertToByteArrayOS(File file){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (InputStream in = new FileInputStream(file)){
            int count;
            byte[] bytes = new byte[8192];
            while((count = in.read(bytes)) !=-1){
                out.write(bytes,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    private String getFileMask(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e){
            return "";
        }
    }

    public MultipartFile convertToMultipartFile(DatabaseFileSharingEntity storageEntity) throws IOException {
        return new MyMockMultipartFile(storageEntity.getFileName(),storageEntity.getByteArray());
    }

    @Deprecated
    private void saveFileToRaid(MultipartFile file, RaidArrayFileEntity myFile) {
        try(OutputStream out = new FileOutputStream(myFile.getFilePath());
            InputStream in = file.getInputStream()){
            int count;
            byte[] bytes = new byte[8192];
            while((count = in.read(bytes)) != -1){
                out.write(bytes,0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public RaidArrayFileEntity convert(MultipartFile file){
        RaidArrayFileEntity myFile = new RaidArrayFileEntity();

        myFile.setFileName(file.getOriginalFilename());

        //TODO rework!
        myFile.setFilePath("/home/yoba/Рабочий стол/test" + File.separator + myFile.getFileName());
        myFile.setSize(file.getSize());
        myFile.setLastModified(System.currentTimeMillis());
        myFile.setFileMask(getFileMask(file.getName()));

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        myFile.setImageInfo(new RaidArrayFileInformationEntity("Test File",localDate,"Test"));

        this.saveFileToRaid(file,myFile);
        return myFile;
    }
}

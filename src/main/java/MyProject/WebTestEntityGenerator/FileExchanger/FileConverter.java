package MyProject.WebTestEntityGenerator.FileExchanger;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.ImageInfo;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.StorageEntity;
import MyProject.WebTestEntityGenerator.MVCForms.FileForm;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FileConverter {

    public MyFile convert(File file){
        MyFile myFile = new MyFile();
        myFile.setFileName(file.getName());
        myFile.setFilePath(file.getPath());
        myFile.setSize(file.length());
        myFile.setLastModified(System.currentTimeMillis());
        myFile.setFileMask(getFileMask(file.getName()));
        myFile.setImageInfo(new ImageInfo());
        return myFile;
    }


    public FileForm convert (MyFile myFile) throws IOException {
        FileForm fileForm = new FileForm();
        File file = new File(myFile.getFilePath());
        FileTime fileTime =
                Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime();
        LocalDate localDate = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        fileForm.setBytes(
                Base64.encodeBase64String(
                        convertToByteArrayOS(new File(myFile.getFilePath())).toByteArray()
                )
        );

        String locationInfo = Arrays.stream(myFile.getFilePath().split("/"))
                .skip(3).limit(5).collect(Collectors.joining("/"));

        fileForm.setLocationInfo(locationInfo);
        fileForm.setLocalDate(localDate);
        fileForm.setPictureId(myFile.getId());
        fileForm.setStatus(myFile.getImageInfo().getStatus());

        return fileForm;
    }

    public StorageEntity convertToStorageEntity(MultipartFile multipartFile){
        StorageEntity storageEntity = new StorageEntity();
        storageEntity.setFileName(multipartFile.getOriginalFilename());

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        storageEntity.setImageInfo(new ImageInfo("Test File",localDate,
                "Upload at " + localDate.toString()));

        return storageEntity;
    }

    public StorageEntity convertToStorageEntity(File file){
        StorageEntity storageEntity = new StorageEntity();
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

    @Deprecated
    private void saveFileToRaid(MultipartFile file, MyFile myFile) {
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
    public MyFile convert(MultipartFile file){
        MyFile myFile = new MyFile();

        myFile.setFileName(file.getOriginalFilename());

        //TODO rework!
        myFile.setFilePath("/home/yoba/Рабочий стол/test" + File.separator + myFile.getFileName());
        myFile.setSize(file.getSize());
        myFile.setLastModified(System.currentTimeMillis());
        myFile.setFileMask(getFileMask(file.getName()));

        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        myFile.setImageInfo(new ImageInfo("Test File",localDate,"Test"));

        this.saveFileToRaid(file,myFile);
        return myFile;
    }
}

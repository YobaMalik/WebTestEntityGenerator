package MyProject.WebTestEntityGenerator.FileExchanger;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
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

    public MyFile convert(MultipartFile file){
        MyFile myFile = new MyFile();
        myFile.setFileName(file.getOriginalFilename());
        myFile.setFilePath("/home/yoba/Рабочий стол/test" + File.separator+myFile.getFileName());
        myFile.setSize(file.getSize());
        myFile.setLastModified(System.currentTimeMillis());
        this.saveFileToRaid(file,myFile);
        return myFile;
    }

    private void saveFileToRaid(MultipartFile file, MyFile myFile) {

        try(OutputStream out = new FileOutputStream(myFile.getFilePath());
            InputStream in = file.getInputStream()){
            int count;
            byte[] bytes = new byte[8192];
            while ( (count = in.read(bytes))!= -1){
                out.write(bytes,0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFile convert(File file){
        MyFile myFile = new MyFile();
        myFile.setFileName(file.getName());
        myFile.setFilePath(file.getPath());
        myFile.setSize(file.length());
        myFile.setLastModified(System.currentTimeMillis());
        myFile.setFileMask(getFileMask(file.getName()));

        return myFile;
    }

    private String getFileMask(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e){
            return "";
        }
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
        fileForm.setStatus(myFile.getStatus());

        return fileForm;
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
}

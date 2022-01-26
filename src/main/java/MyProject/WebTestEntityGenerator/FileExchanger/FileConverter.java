package MyProject.WebTestEntityGenerator.FileExchanger;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.MVCForms.FileForm;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;

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

    public FileForm convert (MyFile myFile){
        FileForm fileForm = new FileForm();
        fileForm.setBytes(convertToByteArrayOS(new File(myFile.getFilePath())).toByteArray());
        fileForm.setStatus(myFile.getStatus());
        return fileForm;
    }

    public ByteArrayOutputStream convertToByteArrayOS(File file){
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

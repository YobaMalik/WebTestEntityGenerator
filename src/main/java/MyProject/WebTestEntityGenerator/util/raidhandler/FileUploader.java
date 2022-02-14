package MyProject.WebTestEntityGenerator.util.raidhandler;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileUploader {

    @Deprecated
    public ByteArrayOutputStream upload(File file){
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

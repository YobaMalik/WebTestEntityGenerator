package MyProject.WebTestEntityGenerator.FileExchanger;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class FileUploader {
    public void upload(String path, HttpServletResponse response){

        try (InputStream in = new FileInputStream(path);
             OutputStream out = response.getOutputStream()){
            int count;
            byte[] bytes = new byte[8192];
            while((count = in.read(bytes)) !=-1){
                out.write(bytes,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

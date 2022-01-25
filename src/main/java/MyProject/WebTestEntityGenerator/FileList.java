package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class FileList {

    @Autowired
    FileConverter fileConverter;

    public void getFilelist(String filePath, List<MyFile> fileMap, String fileMask){
        File[] files = new File(filePath).listFiles();
        for (File file : files){
            if (!file.isDirectory()) {
                fileMap.add(fileConverter.convert(file));
            } else{
                this.getFilelist(file.getPath(),fileMap, fileMask);
            }
        }
    }

}

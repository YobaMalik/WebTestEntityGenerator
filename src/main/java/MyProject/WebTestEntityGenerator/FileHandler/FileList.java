package MyProject.WebTestEntityGenerator.FileHandler;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class FileList {

    @Autowired
    FileConverter fileConverter;

    @Autowired
    GenericFilter filter;

    public void getFileList(String filePath, List<MyFile> fileMap, String fileMask){

        File[] files = new File(filePath).listFiles(filter);

        assert files != null;
        for (File file : files){
            if (!file.isDirectory()) {
                fileMap.add(fileConverter.convert(file));
            } else{
                this.getFileList(file.getPath(),fileMap, fileMask);
            }
        }

        files = new File(filePath).listFiles();

        assert files != null;
        for (File file : files){
            if (file.isDirectory()) {
                this.getFileList(file.getPath(),fileMap, fileMask);
            }
        }
    }

}

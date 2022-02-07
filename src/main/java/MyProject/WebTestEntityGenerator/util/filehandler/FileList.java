package MyProject.WebTestEntityGenerator.util.filehandler;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import MyProject.WebTestEntityGenerator.util.entityhandler.FileDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileList {

    @Autowired
    FileDTOConverter fileConverter;

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

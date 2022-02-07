package MyProject.WebTestEntityGenerator.util.threadtest;

import MyProject.WebTestEntityGenerator.util.filehandler.FileList;
import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileSearchThread implements Runnable {

    private FileList files;

    @Autowired
    public FileSearchThread(FileList files){
        this.files = files;
       // this.run();
    }

    @Getter
    List<MyFile> fileMap = new ArrayList<>();

    @Override
    public void run() {
        System.out.println("Start vi von zulul");
        files.getFileList("/mnt/1F1F7D497672B852",fileMap, "");
        System.out.println(Thread.currentThread().getName()+" " + fileMap.size());
    }

}

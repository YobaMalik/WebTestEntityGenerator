package MyProject.WebTestEntityGenerator.ThreadTest;

import MyProject.WebTestEntityGenerator.FileList;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileSearchThread implements Runnable {

    private FileList files;

    @Autowired
    public FileSearchThread(FileList files){
        this.files = files;
        this.run();
    }

    @Getter
    List<MyFile> fileMap = new ArrayList<>();

    @Override
    public void run() {
        System.out.println("vi von zulul");
        files.getFilelist("/media/yoba/1F1F7D497672B852",fileMap, "");
        System.out.println(Thread.currentThread().getName()+" " + fileMap.size());
    }

}

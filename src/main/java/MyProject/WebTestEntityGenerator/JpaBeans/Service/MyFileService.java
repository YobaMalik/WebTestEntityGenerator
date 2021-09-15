package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.MyFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFileService {

    @Autowired
    private MyFileRepository myFileRepository;

    public List<MyFile> findAll() {
        return  myFileRepository.findAll();
    }

    public void addFiles(MyFile myFile){
        myFileRepository.save(myFile);
    }

}

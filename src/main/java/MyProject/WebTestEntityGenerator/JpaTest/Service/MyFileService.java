package MyProject.WebTestEntityGenerator.JpaTest.Service;

import MyProject.WebTestEntityGenerator.JpaTest.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaTest.Repository.MyFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyFileService {

    @Autowired
    private MyFileRepository myFileRepository;

    public List<MyFile> findAll() {
        return  myFileRepository.findAll();
    }

    public void addFiles(){
        MyFile myFile = new MyFile();
        myFile.setFileName("12312asd");
        myFile.setId(1L);
        myFileRepository.save(myFile);
    }

}

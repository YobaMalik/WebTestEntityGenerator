package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.MVCForms.FileExchangerForm;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyFileService {

    private FileRepository fileRepository;
    private FileConverter converter;

    public MyFileService(@Autowired FileRepository fileRepository,
                         @Autowired FileConverter converter){
        this.converter = converter;
        this.fileRepository = fileRepository;
    }

    public Map<String,MyFile> findAll() {
        Map<String,MyFile> fileMap = new HashMap<>();
        fileRepository.findAll().forEach(e-> {
            fileMap.putIfAbsent(e.getFilePath(),e);
        });
        return fileMap;
    }

    public void addFile(MyFile myFile){
        fileRepository.save(myFile);
    }

    public void addFiles(List<MyFile> files){
        fileRepository.saveAll(files);
    }

    public void addFiles(FileExchangerForm form){
        fileRepository.saveAll(this.convertMockMultiPartFile(form.getFiles()));
    }

    private List<MyFile> convertMockMultiPartFile(List<MultipartFile> files){
        List<MyFile> myFileList = new ArrayList<>();
        files.forEach( e-> myFileList.add(converter.convert(e)));
        return myFileList;
    }

    public void findByPart(){
        fileRepository.findAll();
    }

}

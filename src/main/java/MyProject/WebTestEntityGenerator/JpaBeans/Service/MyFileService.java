package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.FileExchanger.FileConverter;
import MyProject.WebTestEntityGenerator.MVCForms.FileExchangerForm;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.FileRepository;
import MyProject.WebTestEntityGenerator.MVCForms.FileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

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
        fileRepository.findAll().forEach(e-> fileMap.putIfAbsent(e.getFilePath(),e));
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

    public MyFile getPicById(Long id){
        Optional<MyFile> result = fileRepository.findById(id);
        return result.orElse(new MyFile());
    }

    public void updateEntity(FileForm fileForm){
       Optional<MyFile> myFile = fileRepository.findById(fileForm.getPictureId());
       if(myFile.isPresent()) {
           myFile.get().setStatus(fileForm.getStatus());
           fileRepository.save(myFile.get());
       }
    }

}

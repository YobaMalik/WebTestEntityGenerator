package MyProject.WebTestEntityGenerator.FileExchanger;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
public class Form {

    private List<MultipartFile> files;

    private Map<String, MyFile> myFileMap;

    private String filePath;

    private String zulul;

}

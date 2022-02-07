package MyProject.WebTestEntityGenerator.rest.mvcforms;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class FileExchangerForm {

    private List<MultipartFile> files;
    private Map<String, MyFile> myFileMap;
    private String filePath;
    private String zulul;

}

package MyProject.WebTestEntityGenerator.FileHandler;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

@Data
@Component
public class GenericFilter implements FilenameFilter {

    private String[] masks = new String[]{"png", "img", "jpeg", "jpg_320x240", "jpg_240x320", "jpg"};

    @Override
    public boolean accept(File dir, String name) {
        for (String mask: masks){
            if(name.toLowerCase().endsWith(mask.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

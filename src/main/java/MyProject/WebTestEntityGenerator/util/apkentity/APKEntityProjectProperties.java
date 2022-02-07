package MyProject.WebTestEntityGenerator.util.apkentity;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APKEntityProjectProperties {

    @Getter private static final Properties properties = new Properties();

    static {
        setPropValue();
    }

    private static void setPropValue() {
        try(InputStream in = new FileInputStream("src/main/resources/ProjectProperties.properties")){
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

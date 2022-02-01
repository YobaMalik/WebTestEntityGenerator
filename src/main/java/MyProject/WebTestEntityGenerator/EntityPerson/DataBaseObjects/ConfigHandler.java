package MyProject.WebTestEntityGenerator.EntityPerson.DataBaseObjects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigHandler implements IDataBaseMapper{

    @Getter @Setter private static ConcurrentHashMap<String, List<String>> valuesFromConfig;

    static {
        TypeReference<ConcurrentHashMap<String, List<String>>> typeReference =
                new TypeReference<>(){};

        ObjectMapper mapper = new ObjectMapper();

        try {
            //TODO replace from json to DB
            valuesFromConfig = mapper.readValue(new File("src/main/resources/TestData.json"),typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(){
        return null;
    }

    @Override
    public void getMapObjects() {

    }

    @Override
    public List<?> setMap() {
        return null;
    }

}

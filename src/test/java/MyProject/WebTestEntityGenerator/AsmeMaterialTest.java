package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.services.AsmeMaterialTensileStrengthService;
import MyProject.WebTestEntityGenerator.util.ExcelValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class AsmeMaterialTest {

    @Autowired
    AsmeMaterialTensileStrengthService service;

    @Test
    public void entitySaveTest() throws IOException {
        ExcelValue value = new ExcelValue();
        service.saveAllMaterial(value.getValues());
    }
}

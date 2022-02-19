package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.AsmeMaterialTensileStrengthEntity;
import MyProject.WebTestEntityGenerator.db.repository.AsmeMaterialTensileStrengthRepository;
import MyProject.WebTestEntityGenerator.rest.dto.AsmeMaterialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AsmeMaterialTensileStrengthService {

    private  AsmeMaterialTensileStrengthRepository repository;

    public AsmeMaterialTensileStrengthService(@Autowired AsmeMaterialTensileStrengthRepository repository) {
        this.repository = repository;
    }

    public void saveAllMaterial(List<AsmeMaterialDTO> materials){

        List<AsmeMaterialTensileStrengthEntity> result = new ArrayList<>();

        materials.forEach(e -> {
            AsmeMaterialTensileStrengthEntity entity = new AsmeMaterialTensileStrengthEntity();
            entity.setGrade(e.getGrade());
            entity.setNominalComposition(e.getNominalComposition());
            entity.setUns(e.getUns());
            entity.setSpec(e.getSpec());
            entity.setId(e.getId());
            result.add(entity);
        });

        repository.saveAll(result);
    }
}

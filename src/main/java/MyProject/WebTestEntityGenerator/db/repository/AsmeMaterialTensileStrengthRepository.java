package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.AsmeMaterialTensileStrengthEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsmeMaterialTensileStrengthRepository extends CrudRepository<AsmeMaterialTensileStrengthEntity, Long> {
}

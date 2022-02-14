package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.TestPersonForSoftwareComplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestPersonForSoftwareComplexRepository extends JpaRepository<TestPersonForSoftwareComplexEntity, Long> {

    List<TestPersonForSoftwareComplexEntity> findByLastNameContaining(String lastName);

}

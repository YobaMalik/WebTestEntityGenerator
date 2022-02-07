package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageEntityRepository extends JpaRepository<StorageEntity, Long> {

}

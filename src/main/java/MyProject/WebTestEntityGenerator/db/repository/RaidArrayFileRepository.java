package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaidArrayFileRepository extends JpaRepository<RaidArrayFileEntity, Long> {
    //findBy
}

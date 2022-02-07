package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<MyFile, Long> {
    //findBy
}

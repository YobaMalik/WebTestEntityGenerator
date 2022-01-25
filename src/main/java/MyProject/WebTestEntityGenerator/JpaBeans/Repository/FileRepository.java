package MyProject.WebTestEntityGenerator.JpaBeans.Repository;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<MyFile, Long> {
    //findBy
}

package MyProject.WebTestEntityGenerator.JpaTest.Repository;

import MyProject.WebTestEntityGenerator.JpaTest.Entity.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyFileRepository extends JpaRepository<MyFile, Integer> {
}

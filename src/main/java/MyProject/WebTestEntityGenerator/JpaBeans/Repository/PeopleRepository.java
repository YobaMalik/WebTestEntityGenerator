package MyProject.WebTestEntityGenerator.JpaBeans.Repository;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastNameContaining(String lastName);

}

package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastNameContaining(String lastName);

}

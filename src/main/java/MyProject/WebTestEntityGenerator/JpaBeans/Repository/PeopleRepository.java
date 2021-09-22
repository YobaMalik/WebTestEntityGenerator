package MyProject.WebTestEntityGenerator.JpaBeans.Repository;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<Person, Long> {
}

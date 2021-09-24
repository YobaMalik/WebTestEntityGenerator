package MyProject.WebTestEntityGenerator.JpaBeans.Repository;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}

package MyProject.WebTestEntityGenerator.db.repository;

import MyProject.WebTestEntityGenerator.db.entity.AuthorisationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorisationUserRepository extends JpaRepository<AuthorisationUserEntity, Long> {
    AuthorisationUserEntity findByUserName(String userName);
}

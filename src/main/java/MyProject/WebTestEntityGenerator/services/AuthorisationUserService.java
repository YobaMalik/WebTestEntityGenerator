package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.AuthorisationUserEntity;
import MyProject.WebTestEntityGenerator.db.repository.AuthorisationUserRepository;
import MyProject.WebTestEntityGenerator.rest.mvcforms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorisationUserService {

    @Autowired
    private AuthorisationUserRepository userRepository;

    public void createUser(AuthorisationUserEntity user) {
        userRepository.save(user);
    }

    public AuthorisationUserEntity findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void registration(RegistrationForm form) {
        System.out.println(form);
        AuthorisationUserEntity user = new AuthorisationUserEntity();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setRole("USER");
        // user.setId(userRepository.count());
        userRepository.save(user);
    }

}

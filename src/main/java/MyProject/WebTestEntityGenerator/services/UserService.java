package MyProject.WebTestEntityGenerator.services;

import MyProject.WebTestEntityGenerator.db.entity.User;
import MyProject.WebTestEntityGenerator.db.repository.UserRepository;
import MyProject.WebTestEntityGenerator.rest.mvcforms.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public User findByUsername(String userName){
        return userRepository.findByUserName(userName);
    }

    public void registration(RegistrationForm form){
        System.out.println(form);
        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setRole("USER");
        user.setId(userRepository.count() + 2);
        userRepository.save(user);
//        userRepository.save(user);
    }



}

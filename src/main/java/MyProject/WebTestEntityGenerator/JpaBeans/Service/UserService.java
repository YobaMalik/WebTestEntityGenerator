package MyProject.WebTestEntityGenerator.JpaBeans.Service;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.User;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.UserRepository;
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

}

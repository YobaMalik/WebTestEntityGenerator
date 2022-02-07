package MyProject.WebTestEntityGenerator.autorisation;

//import MyProject.WebTestEntityGenerator.JpaBeans.Entity.User;
import MyProject.WebTestEntityGenerator.db.entity.User;
import MyProject.WebTestEntityGenerator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetails implements UserDetailsService {

    @Autowired
    private UserService userService;


    /*public UserDetails(UserService userService){
        this.userService = userService;
    }

     */

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = this.findUserbyUsername(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder ;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(
                    new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(user.getRole());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private User findUserbyUsername(String username) {
        return userService.findByUsername(username);
    }

/*
    private UserOld findUserbyUsername(String username) {
        if (username.equalsIgnoreCase("admin")) {
            return new UserOld(username, "admin", "ADMIN");
        }

        if (username.equalsIgnoreCase("user")) {
            return new UserOld(username, "password1234", "USER");
        }
        return null;
    }

 */

}
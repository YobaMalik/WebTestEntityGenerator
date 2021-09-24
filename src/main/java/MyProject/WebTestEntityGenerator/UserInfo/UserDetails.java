package MyProject.WebTestEntityGenerator.UserInfo;

//import MyProject.WebTestEntityGenerator.JpaBeans.Entity.User;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.User;
import MyProject.WebTestEntityGenerator.JpaBeans.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.CharBuffer;

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
                    new BCryptPasswordEncoder().encode(
                            CharBuffer.wrap(user.getPassword())
                    ));
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
/*
    private User findUserbyUername(String username,String z)  {

        User user = null;
        try {
            con = DriverManager.getConnection(URL, User, pass);
            Statement st = con.createStatement();
            String dbRequest = "SELECT name, password, role FROM ACCAUNT WHERE name=name";
            ResultSet set = st.executeQuery(dbRequest);

            while (set.next()) {
                if(username.equals(set.getString("name"))) user=
                        new User(username,set.getString("password"),
                                set.getString("role").toUpperCase());

            }

            st.close();
            if (username.equalsIgnoreCase("admin")) {
                user= new User(username, "admin123", "ADMIN");
            }

            if (username.equalsIgnoreCase("user")) {
                user= new User(username, "password1234", "USER");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

 */
}
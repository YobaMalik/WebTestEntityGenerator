package MyProject.WebTestEntityGenerator.UserInfo;

import lombok.Getter;

public class User {

    private int id;
    @Getter private String username;
    @Getter private String password;
    @Getter private String roles;

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
package MyProject.WebTestEntityGenerator.UserInfo;

import lombok.Getter;

public class UserOld {

    private int id;
    @Getter private String userName;
    @Getter private String password;
    @Getter private String role;

    public UserOld(String username, String password, String roles) {
        this.userName = username;
        this.password = password;
        this.role = roles;
    }

}
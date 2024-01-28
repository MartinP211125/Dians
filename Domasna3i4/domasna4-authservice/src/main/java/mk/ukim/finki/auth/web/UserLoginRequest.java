package mk.ukim.finki.auth.web;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String username;
    private String password;

    // getters and setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
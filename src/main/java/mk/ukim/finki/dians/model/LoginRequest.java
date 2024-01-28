package mk.ukim.finki.dians.model;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String username;
    private String password;

    // Default constructor for Jackson (used during deserialization)
    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package mk.ukim.finki.dians.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {

    private String username;
    private String password;
    private String repeatPassword;
    private String email;

    // Default constructor for Jackson (used during deserialization)
    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }

    // Getters and setters

}

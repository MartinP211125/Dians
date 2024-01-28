package mk.ukim.finki.dians.model;

// UserRegistrationRequest.java
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String repeatPassword;
    private String email;

    // Constructors, getters, and setters

    public UserRegistrationRequest() {
    }

    public UserRegistrationRequest(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "UserRegistrationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

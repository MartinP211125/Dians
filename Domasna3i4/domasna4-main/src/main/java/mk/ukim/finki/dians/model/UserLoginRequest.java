package mk.ukim.finki.dians.model;

// UserLoginRequest.java
public class UserLoginRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters

    public UserLoginRequest() {
    }

    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

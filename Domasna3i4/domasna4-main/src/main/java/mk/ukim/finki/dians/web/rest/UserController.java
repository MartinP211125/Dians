package mk.ukim.finki.dians.web.rest;

import mk.ukim.finki.dians.FineWineApplication;
import mk.ukim.finki.dians.model.User;
import mk.ukim.finki.dians.model.UserLoginRequest;
import mk.ukim.finki.dians.model.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user-controller")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/register-user")
    public ResponseEntity<String> registerUser() {
        UserRegistrationRequest registrationRequest = new UserRegistrationRequest("john", "password", "password", "john@example.com");

        ResponseEntity<String> registrationResponse = restTemplate.postForEntity(
                FineWineApplication.AUTH_MICROSERVICE_BASE_URL + "/register",
                registrationRequest,
                String.class
        );

        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/login-user")
    public ResponseEntity<String> loginUser() {
        UserLoginRequest loginRequest = new UserLoginRequest("john", "password");

        ResponseEntity<String> loginResponse = restTemplate.postForEntity(
                FineWineApplication.AUTH_MICROSERVICE_BASE_URL + "/login",
                loginRequest,
                String.class
        );

        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/get-user")
    public ResponseEntity<User> getUser() {
        ResponseEntity<User> getUserResponse = restTemplate.exchange(
                FineWineApplication.AUTH_MICROSERVICE_BASE_URL + "/user/{username}",
                HttpMethod.GET,
                null,
                User.class,
                "john"
        );

        return ResponseEntity.ok(getUserResponse.getBody());
    }
}
package mk.ukim.finki.auth.web;

import mk.ukim.finki.auth.model.User;
import mk.ukim.finki.auth.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.auth.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.auth.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
class AuthenticationMicroservice {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest request) {
        try {
            authService.register(request.getUsername(), request.getPassword(), request.getRepeatPassword(), request.getEmail());
            return ResponseEntity.ok("User registered successfully");
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserLoginRequest request) {
        try {
            // Authenticate user (you need to implement this in your AuthService)
            boolean loginSuccessful = authService.login(request.getUsername(), request.getPassword());

            // Return a boolean indicating whether the login was successful
            return ResponseEntity.ok(loginSuccessful);
        } catch (InvalidUserCredentialsException | InvalidArgumentsException ex) {
            return ResponseEntity.ok(false); // or ResponseEntity.ok(Boolean.FALSE) for consistency
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = authService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
package mk.ukim.finki.auth.service;

import mk.ukim.finki.auth.model.User;
import mk.ukim.finki.auth.model.exceptions.PasswordsDoNotMatchException;

import java.util.List;

public interface AuthService {
    Boolean login(String username, String password);

    public User register(String username, String password, String repeatPassword, String email) throws PasswordsDoNotMatchException;
    List<User> findAll();

    User getUserByUsername(String username);
}

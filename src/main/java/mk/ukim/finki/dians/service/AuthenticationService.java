package mk.ukim.finki.dians.service;


import mk.ukim.finki.dians.model.User;
import mk.ukim.finki.dians.model.exceptions.PasswordsDoNotMatchException;

import java.util.List;

public interface AuthenticationService {

    User login(String username, String password);

    public User register(String username, String password, String repeatPassword, String email) throws PasswordsDoNotMatchException;
    List<User> findAll();

}

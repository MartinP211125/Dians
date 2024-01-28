package mk.ukim.finki.auth.service.impl;

import mk.ukim.finki.auth.model.User;
import mk.ukim.finki.auth.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.auth.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.auth.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.auth.repository.UserRepository;
import mk.ukim.finki.auth.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepositoryJpa;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepositoryJpa = userRepository;
    }

    @Override
    public Boolean login(String username, String password) {
        if (credentialsInvalid(username, password)) {
            throw new InvalidArgumentsException();
        }

        User user = userRepositoryJpa.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
        return (user != null) ? Boolean.TRUE:Boolean.FALSE;

    }

    private boolean credentialsInvalid(String username, String password) {
        return username == null || password == null || username.isEmpty() || password.isEmpty();
    }

    @Override
    public User register(String username, String password, String repeatPassword, String email) throws PasswordsDoNotMatchException {
        if (credentialsInvalid(username, password)) {
            throw new InvalidArgumentsException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        User user = new User(username, password, email);
        return userRepositoryJpa.save(user);

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepositoryJpa.findByUsername(username).orElseThrow(InvalidUserCredentialsException::new);
    }
}

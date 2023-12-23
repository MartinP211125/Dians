package mk.ukim.finki.dians.service.imp;

import mk.ukim.finki.dians.model.User;
import mk.ukim.finki.dians.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dians.repository.UserRepository;
import mk.ukim.finki.dians.repository.jpa.UserRepositoryJpa;
import mk.ukim.finki.dians.service.AuthenticationService;
import org.springframework.stereotype.Service;
import mk.ukim.finki.dians.model.exceptions.InvalidUserCredentialsException;

import java.util.List;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    private final UserRepositoryJpa userRepository;

    public AuthenticationServiceImp(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (credentialsInvalid(username, password)) {
            throw new InvalidArgumentsException();
        }

        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);

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
        return userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}

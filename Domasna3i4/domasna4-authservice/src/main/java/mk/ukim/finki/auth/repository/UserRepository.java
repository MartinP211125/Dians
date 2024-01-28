package mk.ukim.finki.auth.repository;

import mk.ukim.finki.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    @Override
    <S extends User> S save(S entity);

    public void deleteByUsername(String username);
}

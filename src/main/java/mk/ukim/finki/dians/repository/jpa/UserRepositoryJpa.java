package mk.ukim.finki.dians.repository.jpa;

import mk.ukim.finki.dians.bootstrap.DataHolder;
import mk.ukim.finki.dians.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, String> {
    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    @Override
    <S extends User> S save(S entity);

    public void deleteByUsername(String username);
}

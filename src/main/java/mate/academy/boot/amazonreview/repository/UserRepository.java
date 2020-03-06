package mate.academy.boot.amazonreview.repository;

import java.util.Optional;
import mate.academy.boot.amazonreview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

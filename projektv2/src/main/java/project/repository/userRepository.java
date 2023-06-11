package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.domain.entity.user;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmailAndPassword(String email, String password);

    user findByEmail(String email);

}

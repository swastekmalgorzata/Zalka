package pl.ug.ajakubik.projektv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ug.ajakubik.projektv2.domain.entity.user;

import java.util.Optional;


public interface userRepository extends JpaRepository<user, Long> {

    user findByEmail(String email);

    Optional<user> findByEmailAndPassword(String email, String password);
}

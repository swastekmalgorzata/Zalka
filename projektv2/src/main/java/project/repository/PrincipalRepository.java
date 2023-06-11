package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.entity.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
}
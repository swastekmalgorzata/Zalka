package pl.ug.ajakubik.projektv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ug.ajakubik.projektv2.domain.entity.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
}
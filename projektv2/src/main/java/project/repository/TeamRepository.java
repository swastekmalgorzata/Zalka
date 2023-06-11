package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
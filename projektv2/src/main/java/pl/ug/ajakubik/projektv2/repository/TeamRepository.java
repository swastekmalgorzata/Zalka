package pl.ug.ajakubik.projektv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ug.ajakubik.projektv2.domain.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
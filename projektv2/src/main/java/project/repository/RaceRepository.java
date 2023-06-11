package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
package pl.ug.ajakubik.projektv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ug.ajakubik.projektv2.domain.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
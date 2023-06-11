package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
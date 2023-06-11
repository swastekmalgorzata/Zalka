package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.domain.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
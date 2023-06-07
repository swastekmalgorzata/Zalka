package pl.ug.ajakubik.projektv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ug.ajakubik.projektv2.domain.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
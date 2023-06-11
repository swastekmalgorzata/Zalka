package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.domain.dto.Car.AddCarDto;
import project.domain.dto.Car.CarDto;
import project.domain.entity.Car;
import project.domain.entity.Team;
import project.exceptions.NotFoundException;
import project.repository.CarRepository;
import project.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CarService {

    final CarRepository carRepository;
    final TeamRepository teamRepository;

    public CarService(@Autowired CarRepository carRepository,
                      @Autowired TeamRepository teamRepository
    ) {
        this.carRepository = carRepository;
        this.teamRepository = teamRepository;
    }

    public void addCar(AddCarDto car) {
        Car newCar = new Car(car.getManufacturer(), car.getSeason(),
                car.getRaces(), car.getWins(), car.getEngine(), null);
        this.carRepository.save(newCar);
    }

    public void addTeam(Long teamId, Long carId) {
        Team team = this.teamRepository.getById(teamId);
        Car car = this.carRepository.getById(carId);
        car.setTeam(team);
        Set<Car> teamCars = team.getCars();
        teamCars.add(car);
        team.setCars(teamCars);
    }

    public void addRace(Long carId) {
        Car car = this.carRepository.getById(carId);
        car.setRaces(car.getRaces() + 1);
    }

    public void addWin(Long carId) {
        Car car = this.carRepository.getById(carId);
        car.setWins(car.getWins() + 1);
    }


    public List<CarDto> getAllCars() {
        List<CarDto> result = new ArrayList<>();
        for (Car car : this.carRepository.findAll()) {
            result.add(new CarDto(car));
        }

        return result;
    }

    public Car getCarById(Long id) {
        return this.carRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteCarById(Long id) {
        try {
            this.carRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    public void editCar(Car car) {
        Car carToEdit = this.getCarById(car.getId());
        carToEdit.setEngine(car.getEngine());
        carToEdit.setManufacturer(car.getManufacturer());
        carToEdit.setRaces(car.getRaces());
        carToEdit.setSeason(car.getSeason());
        carToEdit.setWins(car.getWins());
        carToEdit.setTeam(car.getTeam());
    }

}

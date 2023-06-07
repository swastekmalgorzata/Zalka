package pl.ug.ajakubik.projektv2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ug.ajakubik.projektv2.domain.dto.Car.AddCarDto;
import pl.ug.ajakubik.projektv2.domain.dto.Car.CarDto;
import pl.ug.ajakubik.projektv2.domain.entity.Car;
import pl.ug.ajakubik.projektv2.service.CarService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(@Autowired CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    List<CarDto> getAllCars() {
        return this.carService.getAllCars();
    }

    @GetMapping("/api/cars/{id}")
    Car getCarById(@PathVariable @NotNull Long id) {
        return this.carService.getCarById(id);
    }

    @PostMapping("/api/cars")
    void addCar(@RequestBody @Valid AddCarDto car) {
        this.carService.addCar(car);
    }

    @PostMapping("api/cars/{id}/win")
    void addWin(@PathVariable @NotNull Long id) {
        this.carService.addWin(id);
    }

    @PostMapping("api/cars/{id}/race")
    void addRace(@PathVariable @NotNull Long id) {
        this.carService.addRace(id);
    }

    @DeleteMapping("/api/cars/{id}")
    void deleteCarById(@PathVariable @NotNull Long id) {
        this.carService.deleteCarById(id);
    }

    @PostMapping("/api/cars/edit")
    void editCar(@RequestBody @Valid Car car) {
        this.carService.editCar(car);
    }
}

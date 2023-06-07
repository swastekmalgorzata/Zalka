package pl.ug.ajakubik.projektv2.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.ajakubik.projektv2.domain.dto.Car.AddCarDto;
import pl.ug.ajakubik.projektv2.domain.entity.Car;
import pl.ug.ajakubik.projektv2.service.CarService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class WebCarController {
    private final CarService carService;

    public WebCarController(@Autowired CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/home")
     public String home(){
        return "home";
     }
    @GetMapping("/cars")
    public String allCars(Model model) {
        model.addAttribute("allCars", carService.getAllCars());
        return "cars-all";
    }

    @GetMapping("/carAdd")
    public String carAddForm(Model model) {
        model.addAttribute("addCarDto", new AddCarDto());
        return "cars-add";
    }

    @PostMapping("/carAdd")
    public String processPostOrderCar(@Valid AddCarDto addCarDto, Errors errors) {
        if (errors.hasErrors()) {
            return "cars-add";
        }
        carService.addCar(addCarDto);
        return "redirect:/cars";
    }

    @GetMapping("/deleteCar/{id}")
    public String processDeleteOrderCar(@PathVariable @NotNull Long id) {
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("/editCar/{id}")
    public String editCarForm(Model model, @PathVariable @NotNull Long id) {
        Car car = new Car();
        car.setId(id);
        model.addAttribute("car", car);
        return "cars-edit";
    }

    @PostMapping("/editCar")
    public String processEditOrderCar(@Valid Car car, Errors errors) {
        if (errors.hasErrors()) {
            return "cars-edit";
        }
        carService.editCar(car);
        return "redirect:/cars";
    }
}

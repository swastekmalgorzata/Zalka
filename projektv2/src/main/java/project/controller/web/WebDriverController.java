package project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.domain.dto.Driver.AddDriverDto;
import project.domain.entity.Driver;
import project.service.DriverService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class WebDriverController {
    private final DriverService driverService;

    public WebDriverController(@Autowired DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public String allDrivers(Model model) {
        model.addAttribute("allDrivers", driverService.getAllDrivers());
        return "drivers-all";
    }

    @GetMapping("/driverAdd")
    public String driverAddForm(Model model) {
        model.addAttribute("addDriverDto", new AddDriverDto());
        return "drivers-add";
    }

    @PostMapping("/driverAdd")
    public String processPostOrderDriver(@Valid AddDriverDto addDriverDto, Errors errors) {
        if (errors.hasErrors()) {
            return "drivers-add";
        }
        driverService.addDriver(addDriverDto);
        return "redirect:/drivers";
    }

    @GetMapping("/deleteDriver/{id}")
    public String processDeleteOrderDriver(@PathVariable @NotNull Long id) {
        driverService.deleteDriverById(id);
        return "redirect:/drivers";
    }

    @GetMapping("/editDriver/{id}")
    public String editDriverForm(Model model, @PathVariable @NotNull Long id) {
        Driver driver = new Driver();
        driver.setId(id);
        model.addAttribute("driver", driver);
        return "drivers-edit";
    }

    @PostMapping("/editDriver")
    public String processEditOrderDriver(@Valid Driver driver, Errors errors) {
        if (errors.hasErrors()) {
            return "drivers-edit";
        }
        driverService.editDriver(driver);
        return "redirect:/drivers";
    }
}

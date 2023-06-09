package project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.domain.dto.Driver.AddDriverDto;
import project.domain.dto.Driver.DriverDto;
import project.domain.dto.Race.RaceDto;
import project.domain.entity.Driver;
import project.service.DriverService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@RestController
public class DriverController {
    private final DriverService driverService;

    public DriverController(@Autowired DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/api/drivers")
    List<DriverDto> getAllDrivers() {
        return this.driverService.getAllDrivers();
    }

    @GetMapping("/api/drivers/{id}")
    DriverDto getDriverById(@PathVariable @NotNull Long id) {
        return this.driverService.getDriverById(id);
    }

    @GetMapping("/api/drivers/{id}/races")
    Set<RaceDto> getDriversRaces(@PathVariable @NotNull Long id) {
        return this.driverService.getDriversRaces(id);
    }

    @PostMapping("/api/drivers")
    void addDriver(@RequestBody @Valid AddDriverDto driver) {
        this.driverService.addDriver(driver);
    }

    @DeleteMapping("/api/drivers/{id}")
    void deleteDriverById(@PathVariable @NotNull Long id) {
        this.driverService.deleteDriverById(id);
    }

    @PostMapping("/api/drivers/edit")
    void editDriver(@RequestBody @Valid Driver driver) {
        this.driverService.editDriver(driver);
    }
}

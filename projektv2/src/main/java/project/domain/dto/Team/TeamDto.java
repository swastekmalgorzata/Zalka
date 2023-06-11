package project.domain.dto.Team;

import project.domain.dto.Car.CarDto;
import project.domain.dto.Driver.DriverDto;
import project.domain.entity.Principal;
import project.domain.entity.Team;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TeamDto {

    private Long id;

    private Set<DriverDto> drivers;
    private Set<CarDto> cars;
    private String name;
    private Principal principal;

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.drivers = team.getDrivers().stream().map(DriverDto::new).collect(toSet());
        this.cars = team.getCars().stream().map(CarDto::new).collect(toSet());
        this.principal = team.getPrincipal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DriverDto> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<DriverDto> drivers) {
        this.drivers = drivers;
    }

    public Set<CarDto> getCars() {
        return cars;
    }

    public void setCars(Set<CarDto> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}

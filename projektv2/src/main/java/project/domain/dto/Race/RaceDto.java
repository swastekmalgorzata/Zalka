package project.domain.dto.Race;

import project.domain.dto.Driver.DriverDto;
import project.domain.entity.Race;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class RaceDto {

    private Long id;
    private String country;
    private String grandPrix;
    private int year;
    private int circuits;
    private Set<DriverDto> drivers;

    public RaceDto(Race race) {
        this.id = race.getId();
        this.country = race.getCountry();
        this.grandPrix = race.getGrandPrix();
        this.year = race.getYear();
        this.circuits = race.getCircuits();
        this.drivers = !race.getDrivers().isEmpty() ? race.getDrivers().stream().map(DriverDto::new).collect(toSet()) : null;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGrandPrix() {
        return grandPrix;
    }

    public void setGrandPrix(String grandPrix) {
        this.grandPrix = grandPrix;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCircuits() {
        return circuits;
    }

    public void setCircuits(int circuits) {
        this.circuits = circuits;
    }

    public Set<DriverDto> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<DriverDto> drivers) {
        this.drivers = drivers;
    }
}

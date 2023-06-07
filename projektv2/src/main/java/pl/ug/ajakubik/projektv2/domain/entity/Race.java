package pl.ug.ajakubik.projektv2.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race {

    private Long id;

    private String country;
    private String grandPrix;
    @Min(value = 1950, message = "Year must be greater than 1950!")
    private int year;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int circuits;
    private Set<Driver> drivers;

    public Race() {
    }

    public Race(String country, String grandPrix, int year, int circuits, Set<Driver> drivers) {
        this.country = country;
        this.grandPrix = grandPrix;
        this.year = year;
        this.circuits = circuits;
        this.drivers = drivers;
    }

    @ManyToMany
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

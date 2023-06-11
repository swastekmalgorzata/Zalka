package project.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cars")
public class Car {
    private Long id;

    @NotBlank(message = "Manufacturer field cannot be empty!")
    private String manufacturer;
    @Min(value = 1950, message = "Year must be greater than 1950!")
    private int season;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int races;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int wins;
    @NotBlank(message = "Engine field cannot be empty!")
    private String engine;
    private Team team;

    public Car() {
    }

    public Car(String manufacturer, int season, int races, int wins, String engine, Team team) {
        this.manufacturer = manufacturer;
        this.season = season;
        this.races = races;
        this.wins = wins;
        this.engine = engine;
        this.team = team;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getRaces() {
        return races;
    }

    public void setRaces(int races) {
        this.races = races;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

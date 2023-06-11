package project.domain.dto.Car;

import project.domain.entity.Car;

public class CarDto {

    private Long id;
    private String manufacturer;
    private int season;
    private int races;
    private int wins;
    private String engine;
    private String team;

    public CarDto(Car car) {
        this.id = car.getId();
        this.manufacturer = car.getManufacturer();
        this.season = car.getSeason();
        this.races = car.getRaces();
        this.wins = car.getWins();
        this.team = car.getTeam() != null ? car.getTeam().getName() : null;
        this.engine = car.getEngine();
    }

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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

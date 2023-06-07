package pl.ug.ajakubik.projektv2.domain.dto.Driver;

import pl.ug.ajakubik.projektv2.domain.dto.Race.RaceDto;
import pl.ug.ajakubik.projektv2.domain.entity.Driver;

import java.util.Set;

public class DriverDto {

    public String firstName;
    public String lastName;
    public int age;
    private Long id;
    private int wins;
    private int podiums;
    private String team;
    private Set<RaceDto> driverRaces;


    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.firstName = driver.getFirstName();
        this.lastName = driver.getLastName();
        this.age = driver.getAge();
        this.wins = driver.getWins();
        this.team = driver.getDriverTeam() != null ? driver.getDriverTeam().getName() : null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

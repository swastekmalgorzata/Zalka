package project.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @NotBlank(message = "First name cannot be blank!")
    public String firstName;
    @NotBlank(message = "Last name cannot be blank!")
    public String lastName;
    @NotNull
    @Min(value = 18, message = "Age must be grater than 18!")
    public int age;
    private Long id;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int wins;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int podiums;
    private Team driverTeam;
    private Set<Race> driverRaces;

    public Driver() {
    }


    public Driver(String firstName, String lastName, int age, int wins, int podiums, Team driverTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wins = wins;
        this.podiums = podiums;
        this.driverTeam = driverTeam;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @ManyToOne(fetch = FetchType.EAGER)
    public Team getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(Team team) {
        this.driverTeam = team;
    }

    @ManyToMany(mappedBy = "drivers", fetch = FetchType.EAGER)
    public Set<Race> getDriverRaces() {
        return driverRaces;
    }

    public void setDriverRaces(Set<Race> driverRaces) {
        this.driverRaces = driverRaces;
    }

}

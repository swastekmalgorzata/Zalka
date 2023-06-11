package project.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    private Long id;

    private Set<Driver> drivers;
    private Set<Car> cars;
    private String name;
    private Principal principal;

    public Team() {
    }

    public Team(String name, Principal principal) {
        this.name = name;
        this.principal = principal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "driverTeam", fetch = FetchType.EAGER)
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}

package project.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "principals")
public class Principal {
    @NotBlank(message = "First name cannot be blank!")
    public String firstName;
    @NotBlank(message = "Last name cannot be blank!")
    public String lastName;
    @NotNull
    @Min(value = 18, message = "Age must be grater than 18!")
    public int age;
    private Long id;
    private Team team;

    public Principal() {
    }

    public Principal(String firstName, String lastName, int age, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    @OneToOne(mappedBy = "principal")
    @JsonIgnore
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

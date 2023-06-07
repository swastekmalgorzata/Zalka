package pl.ug.ajakubik.projektv2.domain.dto.Driver;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data

public class AddDriverDto {
    @NotBlank(message = "First name cannot be blank!")
    public String firstName;
    @NotBlank(message = "Last name cannot be blank!")
    public String lastName;
    @NotNull
    @Min(value = 18, message = "Age must be grater than 18!")
    public int age;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int wins;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int podiums;

    public AddDriverDto() {
    }

    public AddDriverDto(String firstName, String lastName, int age, int wins, int podiums) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wins = wins;
        this.podiums = podiums;
    }

}

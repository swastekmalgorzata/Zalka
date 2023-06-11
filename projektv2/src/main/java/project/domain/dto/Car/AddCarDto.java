package project.domain.dto.Car;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class AddCarDto {
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

    public AddCarDto() {
    }

    public AddCarDto(String manufacturer, int season, int races, int wins, String engine) {
        this.manufacturer = manufacturer;
        this.season = season;
        this.races = races;
        this.wins = wins;
        this.engine = engine;
    }
}

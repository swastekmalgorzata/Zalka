package pl.ug.ajakubik.projektv2.domain.dto.Race;

import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Set;

@Data
public class AddRaceDto {

    private String country;
    private String grandPrix;
    @Min(value = 1950, message = "Year must be greater than 1950!")
    private int year;
    @Min(value = 0, message = "Field must be greater than 0!")
    private int circuits;
    private Set<Long> driversIds;

    public AddRaceDto() {
    }

    public AddRaceDto(String country, String grandPrix, int year, int circuits, Set<Long> driversIds) {
        this.country = country;
        this.grandPrix = grandPrix;
        this.year = year;
        this.circuits = circuits;
        this.driversIds = driversIds;
    }
}

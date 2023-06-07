package pl.ug.ajakubik.projektv2.domain.dto.Team;

import lombok.Data;

import java.util.Set;

@Data
public class AddTeamDto {

    private Set<Long> driversIds;
    private Set<Long> carsIds;
    private String name;
    private Long principalId;

    public AddTeamDto() {
    }

    public AddTeamDto(Set<Long> driversIds, Set<Long> carsIds, String name, Long principalId) {
        this.driversIds = driversIds;
        this.carsIds = carsIds;
        this.name = name;
        this.principalId = principalId;
    }
}

package pl.ug.ajakubik.projektv2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.ug.ajakubik.projektv2.domain.dto.Race.AddRaceDto;
import pl.ug.ajakubik.projektv2.domain.dto.Race.RaceDto;
import pl.ug.ajakubik.projektv2.domain.entity.Race;
import pl.ug.ajakubik.projektv2.service.RaceService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class RaceController {
    private final RaceService raceService;

    public RaceController(@Autowired RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/api/races")
    List<RaceDto> getAllRaces() {
        return this.raceService.getAllRaces();
    }

    @GetMapping("/api/races/{id}")
    Race getRaceById(@PathVariable @NotNull Long id) {
        return this.raceService.getRaceById(id);
    }

    @PostMapping("/api/races")
    void addRace(@RequestBody @Valid AddRaceDto race) {
        Race newRace = raceService.raceFromDto(race);
        this.raceService.addRace(newRace);
    }

    @DeleteMapping("/api/races/{id}")
    void deleteRaceById(@PathVariable @NotNull Long id) {
        this.raceService.deleteRaceById(id);
    }

    @PostMapping("/api/races/edit")
    void editRace(@RequestBody @Valid Race race) {
        this.raceService.editRace(race);
    }
}

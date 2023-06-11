package project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.domain.dto.Team.AddTeamDto;
import project.domain.dto.Team.TeamDto;
import project.domain.entity.Team;
import project.service.TeamService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;

    public TeamController(@Autowired TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/api/teams")
    List<TeamDto> getAllTeams() {
        return this.teamService.getAllTeams();
    }

    @GetMapping("/api/teams/{id}")
    Team getTeamById(@PathVariable @NotNull Long id) {
        return this.teamService.getTeamById(id);
    }

    @PostMapping("/api/teams")
    void addTeam(@RequestBody @Valid AddTeamDto team) {
        this.teamService.addTeam(team);
    }

    @DeleteMapping("/api/teams/{id}")
    void deleteTeamById(@PathVariable @NotNull Long id) {
        this.teamService.deleteTeamById(id);
    }

    @PostMapping("/api/teams/edit")
    void editTeam(@RequestBody @Valid Team team) {
        this.teamService.editTeam(team);
    }
}

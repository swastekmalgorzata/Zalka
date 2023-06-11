package project.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.domain.dto.Team.AddTeamDto;
import project.domain.entity.Team;
import project.service.CarService;
import project.service.DriverService;
import project.service.PrincipalService;
import project.service.TeamService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class WebTeamController {
    private final TeamService teamService;
    private final CarService carService;
    private final PrincipalService principalService;
    private final DriverService driverService;

    public WebTeamController(@Autowired TeamService teamService,
                             @Autowired CarService carService,
                             @Autowired PrincipalService principalService,
                             @Autowired DriverService driverService) {
        this.teamService = teamService;
        this.carService = carService;
        this.principalService = principalService;
        this.driverService = driverService;
    }

    @GetMapping("/teams")
    public String allTeams(Model model) {
        model.addAttribute("allTeams", teamService.getAllTeams());
        return "teams-all";
    }

    @GetMapping("/teamAdd")
    public String teamAddForm(Model model) {
        model.addAttribute("team", new AddTeamDto());
        model.addAttribute("allDrivers", driverService.getAllDrivers());
        model.addAttribute("allPrincipals", principalService.getAllPrincipals());
        model.addAttribute("allCars", carService.getAllCars());
        return "teams-add";
    }

    @PostMapping("/teamAdd")
    public String processPostOrderTeam(@Valid AddTeamDto team, Errors errors) {
        if (errors.hasErrors()) {
            return "teams-add";
        }
        teamService.addTeam(team);
        return "redirect:/teams";
    }

    @GetMapping("/deleteTeam/{id}")
    public String processDeleteOrderTeam(@PathVariable @NotNull Long id) {
        teamService.deleteTeamById(id);
        return "redirect:/teams";
    }

    @GetMapping("/editTeam/{id}")
    public String editTeamForm(Model model, @PathVariable @NotNull Long id) {
        Team team = new Team();
        team.setId(id);
        model.addAttribute("team", team);
        model.addAttribute("drivers", driverService.getAllDrivers());
        model.addAttribute("principals", principalService.getAllPrincipals());
        model.addAttribute("cars", carService.getAllCars());
        return "teams-edit";
    }

    @PostMapping("/editTeam")
    public String processEditOrderTeam(@Valid Team team, Errors errors) {
        if (errors.hasErrors()) {
            return "teams-edit";
        }
        teamService.editTeam(team);
        return "redirect:/teams";
    }
}

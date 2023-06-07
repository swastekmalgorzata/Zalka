package pl.ug.ajakubik.projektv2.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.ajakubik.projektv2.domain.dto.Race.AddRaceDto;
import pl.ug.ajakubik.projektv2.domain.entity.Race;
import pl.ug.ajakubik.projektv2.service.DriverService;
import pl.ug.ajakubik.projektv2.service.RaceService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class WebRaceController {
    private final RaceService raceService;
    private final DriverService driverService;

    public WebRaceController(@Autowired RaceService raceService,
                             @Autowired DriverService driverService) {
        this.raceService = raceService;
        this.driverService = driverService;
    }

    @GetMapping("/races")
    public String allRaces(Model model) {
        model.addAttribute("allRaces", raceService.getAllRaces());
        return "races-all";
    }

    @GetMapping("/raceAdd")
    public String raceAddForm(Model model) {
        model.addAttribute("addRaceDto", new AddRaceDto());
        model.addAttribute("allDrivers", driverService.getAllDrivers());
        return "races-add";
    }

    @PostMapping("/raceAdd")
    public String processPostOrderRace(@Valid AddRaceDto addRaceDto, Errors errors) {
        if (errors.hasErrors()) {
            return "races-add";
        }
        Race race = raceService.raceFromDto(addRaceDto);
        raceService.addRace(race);
        return "redirect:/races";
    }

    @GetMapping("/deleteRace/{id}")
    public String processDeleteOrderRace(@PathVariable @NotNull Long id) {
        raceService.deleteRaceById(id);
        return "redirect:/races";
    }

    @GetMapping("/editRace/{id}")
    public String editRaceForm(Model model, @PathVariable @NotNull Long id) {
        Race race = new Race();
        race.setId(id);
        model.addAttribute("race", race);
        model.addAttribute("drivers", this.raceService.getRaceById(id).getDrivers());
        return "races-edit";
    }

    @PostMapping("/editRace")
    public String processEditOrderRace(@Valid Race race, Errors errors) {
        if (errors.hasErrors()) {
            return "races-edit";
        }
        raceService.editRace(race);
        return "redirect:/races";
    }
}

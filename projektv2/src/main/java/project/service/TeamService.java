package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.domain.dto.Team.AddTeamDto;
import project.domain.dto.Team.TeamDto;
import project.domain.entity.Car;
import project.domain.entity.Driver;
import project.domain.entity.Principal;
import project.domain.entity.Team;
import project.exceptions.NotFoundException;
import project.repository.CarRepository;
import project.repository.DriverRepository;
import project.repository.PrincipalRepository;
import project.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    final TeamRepository teamRepository;
    final DriverRepository driverRepository;
    final CarRepository carRepository;
    final PrincipalRepository principalRepository;

    public TeamService(@Autowired TeamRepository teamRepository,
                       @Autowired DriverRepository driverRepository,
                       @Autowired CarRepository carRepository,
                       @Autowired PrincipalRepository principalRepository
    ) {
        this.teamRepository = teamRepository;
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.principalRepository = principalRepository;
    }


    public void addTeam(AddTeamDto team) {
        Principal principal = this.principalRepository.getById(team.getPrincipalId());
        Team newTeam = new Team(team.getName(), principal);
        this.teamRepository.save(newTeam);
        for (Long driverId : team.getDriversIds()) {
            Driver driverToAdd = this.driverRepository.findById(driverId).orElseThrow(NotFoundException::new);
            driverToAdd.setDriverTeam(newTeam);
            this.driverRepository.save(driverToAdd);
        }
        for (Long carId : team.getCarsIds()) {
            Car car = this.carRepository.findById(carId).orElseThrow(NotFoundException::new);
            car.setTeam(newTeam);
            this.carRepository.save(car);
        }
    }

    @Transactional
    public List<TeamDto> getAllTeams() {
        List<Team> teams = this.teamRepository.findAll();
        List<TeamDto> result = new ArrayList<>();
        for (Team team : teams) {
            TeamDto teamDto = new TeamDto(team);
            result.add(teamDto);
        }
        return result;
    }

    @Transactional
    public Team getTeamById(Long id) {
        return this.teamRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteTeamById(Long id) {
        try {
            this.teamRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void editTeam(Team team) {
        Team teamToEdit = this.getTeamById(team.getId());
        teamToEdit.setCars(team.getCars());
        teamToEdit.setDrivers(team.getDrivers());
        teamToEdit.setName(team.getName());
        teamToEdit.setPrincipal(team.getPrincipal());

    }
}

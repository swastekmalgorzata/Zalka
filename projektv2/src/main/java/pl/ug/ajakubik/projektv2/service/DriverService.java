package pl.ug.ajakubik.projektv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.ajakubik.projektv2.domain.dto.Driver.AddDriverDto;
import pl.ug.ajakubik.projektv2.domain.dto.Driver.DriverDto;
import pl.ug.ajakubik.projektv2.domain.dto.Race.RaceDto;
import pl.ug.ajakubik.projektv2.domain.entity.Driver;
import pl.ug.ajakubik.projektv2.domain.entity.Race;
import pl.ug.ajakubik.projektv2.exceptions.NotFoundException;
import pl.ug.ajakubik.projektv2.repository.DriverRepository;
import pl.ug.ajakubik.projektv2.repository.RaceRepository;
import pl.ug.ajakubik.projektv2.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverService {

    final DriverRepository driverRepository;
    final TeamRepository teamRepository;
    final RaceRepository raceRepository;

    public DriverService(@Autowired DriverRepository driverRepository,
                         @Autowired TeamRepository teamRepository,
                         @Autowired RaceRepository raceRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
        this.raceRepository = raceRepository;
    }

    @Transactional
    public void addDriver(AddDriverDto driver) {
        Driver newDriver = new Driver(driver.getFirstName(), driver.getLastName(), driver.getAge(), driver.getWins(), driver.getPodiums(), null);
        this.driverRepository.save(newDriver);
    }

    @Transactional
    public List<DriverDto> getAllDrivers() {
        List<DriverDto> result = new ArrayList<>();
        for (Driver driver : this.driverRepository.findAll()) {
            result.add(new DriverDto(driver));
        }
        return result;
    }

    @Transactional
    public DriverDto getDriverById(Long id) {
        try {
            Driver driver = this.driverRepository.getById(id);
            return new DriverDto(driver);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void deleteDriverById(Long id) {
        try {
            this.driverRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void editDriver(Driver driver) {
        Driver driverToEdit = this.driverRepository.getById(driver.getId());
        driverToEdit.setFirstName(driver.getFirstName());
        driverToEdit.setLastName(driver.getLastName());
        driverToEdit.setAge(driver.getAge());
        driverToEdit.setPodiums(driver.getPodiums());
//        driverToEdit.setTeam(driver.getTeam());
        driverToEdit.setDriverRaces(driver.getDriverRaces());
        driverToEdit.setWins((driver.getWins()));

    }

    @Transactional
    public void addWinToDriver(Long driverId) {
        Driver driverToAddWin = this.driverRepository.getById(driverId);
        driverToAddWin.setWins(driverToAddWin.getWins() + 1);
        driverToAddWin.setPodiums(driverToAddWin.getPodiums() + 1);
    }

    @Transactional
    public void addPodiumToDriver(Long driverId) {
        Driver driverToAddPodium = this.driverRepository.getById(driverId);
        driverToAddPodium.setPodiums(driverToAddPodium.getPodiums() + 1);
    }

//    @Transactional
//    public void addTeam(Long driverId, Long teamId) {
//        Team team = this.teamRepository.getById(teamId);
//        Driver driver = this.driverRepository.getById(driverId);
//        driver.setTeam(team);
//        Set<Driver> teamDrivers = team.getDrivers();
//        teamDrivers.add(driver);
//        team.setDrivers(teamDrivers);
//    }

    @Transactional
    public void addRaces(Long driverId, Set<Long> racesIds) {
        Driver driver = this.driverRepository.getById(driverId);
        Set<Race> races = new HashSet<>();
        for (Long raceId : racesIds) {
            Race race = this.raceRepository.getById(raceId);
            races.add(race);
        }
        driver.setDriverRaces(races);
    }

    public Set<RaceDto> getDriversRaces(Long id) {
        Driver driver = this.driverRepository.getById(id);
        return driver.getDriverRaces().stream().map(RaceDto::new).collect(Collectors.toSet());
    }
}

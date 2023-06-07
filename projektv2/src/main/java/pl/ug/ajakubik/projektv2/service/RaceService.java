package pl.ug.ajakubik.projektv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.ajakubik.projektv2.domain.dto.Race.AddRaceDto;
import pl.ug.ajakubik.projektv2.domain.dto.Race.RaceDto;
import pl.ug.ajakubik.projektv2.domain.entity.Driver;
import pl.ug.ajakubik.projektv2.domain.entity.Race;
import pl.ug.ajakubik.projektv2.exceptions.NotFoundException;
import pl.ug.ajakubik.projektv2.repository.DriverRepository;
import pl.ug.ajakubik.projektv2.repository.RaceRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RaceService {

    final RaceRepository raceRepository;
    final DriverRepository driverRepository;

    public RaceService(@Autowired RaceRepository raceRepository, @Autowired DriverRepository driverRepository) {
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public void addRace(Race race) {
        this.raceRepository.save(race);
    }

    @Transactional
    public Race raceFromDto(AddRaceDto race) {
        Set<Driver> drivers = new HashSet<>();
        for (Long driverId : race.getDriversIds()) {
            drivers.add(this.driverRepository.getById(driverId));
        }
        return new Race(race.getCountry(), race.getGrandPrix(), race.getYear(), race.getCircuits(), drivers);
    }

    @Transactional
    public List<RaceDto> getAllRaces() {
        List<Race> races = this.raceRepository.findAll();
        List<RaceDto> result = new ArrayList<>();
        for (Race race : races) {
            RaceDto raceDto = new RaceDto(race);
            result.add(raceDto);
        }
        return result;
    }

    @Transactional
    public Race getRaceById(Long id) {
        return this.raceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteRaceById(Long id) {
        try {
            this.raceRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void editRace(Race race) {
        Race raceToEdit = this.getRaceById(race.getId());
        raceToEdit.setCircuits(race.getCircuits());
        raceToEdit.setCountry(race.getCountry());
        raceToEdit.setGrandPrix(race.getGrandPrix());
        raceToEdit.setYear(race.getYear());
        raceToEdit.setDrivers(race.getDrivers());

    }
}

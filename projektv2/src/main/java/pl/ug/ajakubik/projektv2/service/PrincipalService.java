package pl.ug.ajakubik.projektv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.ajakubik.projektv2.domain.entity.Principal;
import pl.ug.ajakubik.projektv2.exceptions.NotFoundException;
import pl.ug.ajakubik.projektv2.repository.PrincipalRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrincipalService {
    final PrincipalRepository principalRepository;

    public PrincipalService(@Autowired PrincipalRepository principalRepository) {
        this.principalRepository = principalRepository;
    }

    @Transactional
    public void addPrincipal(Principal principal) {
        this.principalRepository.save(principal);
    }

    @Transactional
    public List<Principal> getAllPrincipals() {
        return this.principalRepository.findAll();
    }

    @Transactional
    public Principal getPrincipalById(Long id) {
        return this.principalRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deletePrincipalById(Long id) {
        try {
            this.principalRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @Transactional
    public void editPrincipal(Principal principal) {
        Principal principalToEdit = this.getPrincipalById(principal.getId());
        principalToEdit.setFirstName(principal.getFirstName());
        principalToEdit.setLastName(principal.getLastName());
        principalToEdit.setAge(principal.getAge());

    }
}

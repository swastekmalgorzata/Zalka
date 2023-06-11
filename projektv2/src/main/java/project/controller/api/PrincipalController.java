package project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.domain.entity.Principal;
import project.service.PrincipalService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class PrincipalController {
    private final PrincipalService principalService;

    public PrincipalController(@Autowired PrincipalService principalService) {
        this.principalService = principalService;
    }

    @GetMapping("/api/principals")
    List<Principal> getAllPrincipals() {
        return this.principalService.getAllPrincipals();
    }

    @GetMapping("/api/principals/{id}")
    Principal getPrincipalById(@PathVariable @NotNull Long id) {
        return this.principalService.getPrincipalById(id);
    }

    @PostMapping("/api/principals")
    void addPrincipal(@RequestBody @Valid Principal principal) {
        this.principalService.addPrincipal(principal);
    }

    @DeleteMapping("/api/principals/{id}")
    void deletePrincipalById(@PathVariable @NotNull Long id) {
        this.principalService.deletePrincipalById(id);
    }

    @PostMapping("/api/principals/edit")
    void editPrincipal(@RequestBody @Valid Principal principal) {
        this.principalService.editPrincipal(principal);
    }
}

package pl.ug.ajakubik.projektv2.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.ajakubik.projektv2.domain.entity.Principal;
import pl.ug.ajakubik.projektv2.service.PrincipalService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class WebPrincipalController {
    private final PrincipalService principalService;

    public WebPrincipalController(@Autowired PrincipalService principalService) {
        this.principalService = principalService;
    }

    @GetMapping("/principals")
    public String allPrincipals(Model model) {
        model.addAttribute("allPrincipals", principalService.getAllPrincipals());
        return "principals-all";
    }

    @GetMapping("/principalAdd")
    public String principalAddForm(Model model) {
        model.addAttribute("principal", new Principal());
        return "principals-add";
    }

    @PostMapping("/principalAdd")
    public String processPostOrderPrincipal(@Valid Principal principal, Errors errors) {
        if (errors.hasErrors()) {
            return "principals-add";
        }
        principalService.addPrincipal(principal);
        return "redirect:/principals";
    }

    @GetMapping("/deletePrincipal/{id}")
    public String processDeleteOrderPrincipal(@PathVariable @NotNull Long id) {
        principalService.deletePrincipalById(id);
        return "redirect:/principals";
    }

    @GetMapping("/editPrincipal/{id}")
    public String editPrincipalForm(Model model, @PathVariable @NotNull Long id) {
        Principal principal = new Principal();
        principal.setId(id);
        model.addAttribute("principal", principal);
        return "principals-edit";
    }

    @PostMapping("/editPrincipal")
    public String processEditOrderPrincipal(@Valid Principal principal, Errors errors) {
        if (errors.hasErrors()) {
            return "principals-edit";
        }
        principalService.editPrincipal(principal);
        return "redirect:/principals";
    }
}

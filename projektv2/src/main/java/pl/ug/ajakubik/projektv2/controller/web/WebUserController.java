package pl.ug.ajakubik.projektv2.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.ajakubik.projektv2.domain.dto.user.RegisterUserDto;
import pl.ug.ajakubik.projektv2.repository.userRepository;
import pl.ug.ajakubik.projektv2.service.userServices;

@Controller
public class WebUserController {

    private userServices userServices;
    @ModelAttribute("user")
    public RegisterUserDto userRegistrationDto(){
        return new RegisterUserDto();
    }

    public WebUserController(userServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public String registerForm(){
        return "registration";
    }

    @PostMapping("/register")
    public  String registerUser(@ModelAttribute("user")RegisterUserDto registerUserDto){
        userServices.registerUser(registerUserDto);
        return "redirect:/registration?success";
    }
}

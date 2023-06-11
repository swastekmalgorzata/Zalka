package project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.domain.dto.user.RegisterUserDto;
import project.service.userServices;

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
        userServices.save(registerUserDto);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

}

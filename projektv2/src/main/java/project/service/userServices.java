package project.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import project.domain.dto.user.RegisterUserDto;
import project.domain.entity.user;

public interface userServices extends UserDetailsService {
    user save(RegisterUserDto registerUserDto);
}


package pl.ug.ajakubik.projektv2.service;

import org.springframework.stereotype.Service;
import pl.ug.ajakubik.projektv2.domain.dto.user.RegisterUserDto;
import pl.ug.ajakubik.projektv2.domain.entity.user;
import pl.ug.ajakubik.projektv2.repository.userRepository;

@Service
public class userServices {
    private  final userRepository userRepo;

    public userServices(userRepository userRepo){
        this.userRepo= userRepo;
    }

    public user registerUser(RegisterUserDto registerUserDto){
            user newUser = new user(registerUserDto.getEmail(),registerUserDto.getPassword());
            return userRepo.save(newUser);
    }

    public user auth(String email, String password){
        return userRepo.findByEmailAndPassword(email, password ).orElse(null);
    }

}

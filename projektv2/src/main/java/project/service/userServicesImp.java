package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.domain.dto.user.RegisterUserDto;
import project.domain.entity.role;
import project.domain.entity.user;
import project.repository.userRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class userServicesImp implements userServices {
    private final userRepository userRepo;

    private BCryptPasswordEncoder passwordEncoder;

    public userServicesImp(userRepository userRepo ) {
        this.userRepo = userRepo;


    }
    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public user save(RegisterUserDto registerUserDto) {
        user newUser = new user(registerUserDto.getEmail(), passwordEncoder.encode(registerUserDto.getPassword()), Arrays.asList(new role("ROLE_USER")));
        return userRepo.save(newUser);
    }

    public user auth(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        user user = userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid login email or password!");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

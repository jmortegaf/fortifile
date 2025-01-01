package com.jmortegaf.fortifile.services;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;
import com.jmortegaf.fortifile.models.User;
import com.jmortegaf.fortifile.repositories.UserRepository;
import com.jmortegaf.fortifile.validators.user.register.UserRegisterValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final List<UserRegisterValidator> userRegisterValidators;

    public UserRegisterService(PasswordEncoder passwordEncoder,
                               UserRepository userRepository,
                               List<UserRegisterValidator> userRegisterValidators) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRegisterValidators = userRegisterValidators;
    }

    public ResponseEntity<?> register(UserRegisterDTO userRegisterDTO) {
        userRegisterValidators.forEach(validator->validator.validate(userRegisterDTO));
        User user = new User(userRegisterDTO,passwordEncoder.encode(userRegisterDTO.password()));
        try {
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}

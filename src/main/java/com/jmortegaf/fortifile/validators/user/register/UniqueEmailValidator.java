package com.jmortegaf.fortifile.validators.user.register;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;
import com.jmortegaf.fortifile.exceptions.UserRegisterErrorException;
import com.jmortegaf.fortifile.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements UserRegisterValidator{

    private final UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserRegisterDTO userRegisterDTO) {
        if(userRepository.existsByEmail(userRegisterDTO.username())){
            throw new UserRegisterErrorException("Email already in use");
        }
    }
}

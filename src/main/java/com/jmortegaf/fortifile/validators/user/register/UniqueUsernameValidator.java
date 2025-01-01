package com.jmortegaf.fortifile.validators.user.register;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;
import com.jmortegaf.fortifile.exceptions.UserRegisterErrorException;
import com.jmortegaf.fortifile.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements UserRegisterValidator{

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserRegisterDTO userRegisterDTO) {
        if(userRepository.existsByUsername(userRegisterDTO.username())){
            throw new UserRegisterErrorException("Username already in use");
        }
    }
}

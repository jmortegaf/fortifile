package com.jmortegaf.fortifile.validators.user.login;

import com.jmortegaf.fortifile.exceptions.LoginErrorException;
import com.jmortegaf.fortifile.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UsernameValidator {

    private final UserRepository userRepository;

    public UsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(String username){
        if(!userRepository.existsByUsername(username))
            throw new LoginErrorException("User doesn't exist");

    }

}

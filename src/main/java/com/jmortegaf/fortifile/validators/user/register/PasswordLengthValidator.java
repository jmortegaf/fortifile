package com.jmortegaf.fortifile.validators.user.register;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;
import com.jmortegaf.fortifile.exceptions.UserRegisterErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordLengthValidator implements UserRegisterValidator{

    @Value("${minimum.password.length}")
    private Integer minimumLength;

    @Override
    public void validate(UserRegisterDTO userRegisterDTO) {
        if(userRegisterDTO.password().length()<minimumLength){
            throw new UserRegisterErrorException(String.format("Password must be at least %d characters long",minimumLength));
        }
    }
}

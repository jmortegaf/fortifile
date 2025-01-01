package com.jmortegaf.fortifile.validators.user.register;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;

public interface UserRegisterValidator {

    void validate(UserRegisterDTO userRegisterDTO);
}

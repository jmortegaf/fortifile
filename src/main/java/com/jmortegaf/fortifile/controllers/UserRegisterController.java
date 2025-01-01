package com.jmortegaf.fortifile.controllers;

import com.jmortegaf.fortifile.dtos.users.UserRegisterDTO;
import com.jmortegaf.fortifile.services.UserRegisterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @GetMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        return userRegisterService.register(userRegisterDTO);
    }
}

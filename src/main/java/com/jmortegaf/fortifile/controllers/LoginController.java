package com.jmortegaf.fortifile.controllers;

import com.jmortegaf.fortifile.dtos.auth.JWTTokenDTO;
import com.jmortegaf.fortifile.dtos.users.UserLoginDTO;
import com.jmortegaf.fortifile.models.User;
import com.jmortegaf.fortifile.services.LoginService;
import com.jmortegaf.fortifile.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO userLoginDTO){
        return loginService.login(userLoginDTO);
    }
}

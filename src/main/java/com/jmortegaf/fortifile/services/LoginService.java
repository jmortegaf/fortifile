package com.jmortegaf.fortifile.services;

import com.jmortegaf.fortifile.dtos.users.UserLoginDTO;
import com.jmortegaf.fortifile.models.User;
import com.jmortegaf.fortifile.validators.user.login.UsernameValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsernameValidator usernameValidator;

    public LoginService(AuthenticationManager authenticationManager,
                        TokenService tokenService, UsernameValidator usernameValidator) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usernameValidator = usernameValidator;
    }

    public ResponseEntity<?> login(UserLoginDTO userLoginDTO) {
        usernameValidator.validate(userLoginDTO.username());
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                userLoginDTO.username(),userLoginDTO.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTToken=tokenService.generateToken((User)authenticatedUser.getPrincipal());
        return ResponseEntity.ok(Map.of("token",JWTToken));
    }
}

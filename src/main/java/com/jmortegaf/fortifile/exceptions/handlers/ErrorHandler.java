package com.jmortegaf.fortifile.exceptions.handlers;

import com.jmortegaf.fortifile.exceptions.LoginErrorException;
import com.jmortegaf.fortifile.exceptions.UserRegisterErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserRegisterErrorException.class)
    public ResponseEntity<?> invalidUserRegisterData(UserRegisterErrorException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message",ex.getMessage()));
    }

    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<?> loginError(LoginErrorException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message",ex.getMessage()));
    }

}

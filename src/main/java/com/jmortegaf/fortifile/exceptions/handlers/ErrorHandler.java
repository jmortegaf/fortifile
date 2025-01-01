package com.jmortegaf.fortifile.exceptions.handlers;

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
                .body(Map.of("error","Bad Request",
                        "message",ex.getMessage()));
    }
}

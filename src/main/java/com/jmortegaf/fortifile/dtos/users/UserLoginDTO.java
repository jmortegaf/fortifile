package com.jmortegaf.fortifile.dtos.users;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(
        @NotBlank String username,
        @NotBlank String password) {}

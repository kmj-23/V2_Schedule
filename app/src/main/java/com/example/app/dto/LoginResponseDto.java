package com.example.app.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private final String email;

    private final String password;

    public LoginResponseDto(String password, String email) {
        this.password = password;
        this.email = email;
    }
}

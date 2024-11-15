package com.example.app.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;

    private final String email;

    private final String password;

    private final Integer age;

    public SignUpRequestDto(String username, String email, String password, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}

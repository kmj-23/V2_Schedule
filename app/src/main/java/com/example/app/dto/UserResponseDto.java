package com.example.app.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;

    private final Integer age;

    public UserResponseDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}

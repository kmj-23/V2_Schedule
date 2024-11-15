package com.example.app.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private final Long id; // 식별자

    private final String username; // 회원가입 때 생성된 유저 이름

    private final String email;

    private final Integer age;



    public SignUpResponseDto(Long id, String username, String email, Integer age ) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

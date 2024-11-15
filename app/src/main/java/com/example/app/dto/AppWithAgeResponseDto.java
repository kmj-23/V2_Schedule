package com.example.app.dto;

import lombok.Getter;

@Getter
public class AppWithAgeResponseDto {
    private final String title;

    private final String contents;

    private final Integer age;

    public AppWithAgeResponseDto(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }
}


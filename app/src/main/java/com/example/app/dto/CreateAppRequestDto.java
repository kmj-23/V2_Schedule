package com.example.app.dto;

import lombok.Getter;

@Getter
public class CreateAppRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    public CreateAppRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}

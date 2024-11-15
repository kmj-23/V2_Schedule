package com.example.app.dto;

import lombok.Getter;

@Getter
public class AppUpdateRequestDto {
    private String title;
    private String contents;

    public AppUpdateRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

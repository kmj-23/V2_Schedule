package com.example.app.dto;

import com.example.app.entity.App;
import lombok.Getter;

@Getter
public class AppResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    public AppResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }



    public static AppResponseDto toDto(App app) {
        return new AppResponseDto(app.getId(), app.getTitle(), app.getContents());
        //매개변수로 전달된 app이 AppResponseDto로 변환되어서 동작
    }
}

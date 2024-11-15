package com.example.app.controller;

import com.example.app.dto.AppResponseDto;
import com.example.app.dto.AppWithAgeResponseDto;
import com.example.app.dto.CreateAppRequestDto;
import com.example.app.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apps")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @PostMapping // 일정 생성
    public ResponseEntity<AppResponseDto> save(@RequestBody CreateAppRequestDto requestDto) {

        AppResponseDto appResponseDto =
                appService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(appResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppResponseDto>> findAll() {
        List<AppResponseDto> appResponsDtoList = appService.findAll();

        return new ResponseEntity<>(appResponsDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppWithAgeResponseDto> findById(@PathVariable Long id) {

        AppWithAgeResponseDto appWithAgeResponseDto = appService.findById(id);

        return new ResponseEntity<>(appWithAgeResponseDto, HttpStatus.OK);

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<AppResponseDto> update(@PathVariable Long id, @RequestBody CreateAppRequestDto requestDto) {
//        AppResponseDto appresponseDto = appService.update(title, contents)
//        return new ResponseEntity<>(appResponseDto, HttpStatus.CREATED);
//    }
//    @PutMapping("/{id}")
//    public Long update(@PathVariable Long id, @RequestBody AppUpdateRequestDto requestDto){
//        return appService.update(requestDto.getTitle(), requestDto.getContents())
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        appService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

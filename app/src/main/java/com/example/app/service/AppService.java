package com.example.app.service;

import com.example.app.dto.AppResponseDto;
import com.example.app.dto.AppWithAgeResponseDto;
import com.example.app.entity.App;
import com.example.app.entity.User;
import com.example.app.repository.AppRepository;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    private final UserRepository userRepository;
    private final AppRepository appRepository;

    public AppResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        App app = new App(title, contents);
        app.setUser(findUser);

        App savedApp = appRepository.save(app);

        return new AppResponseDto(savedApp.getId(), savedApp.getTitle(), savedApp.getContents());
    }

    public List<AppResponseDto> findAll() {
        return appRepository.findAll()
                .stream()
                .map(AppResponseDto::toDto)
                .toList();
    } // 조회된 일정들을 List로 반환

    public AppWithAgeResponseDto findById(Long id) {

        App findApp = appRepository.findByIdOrElseThrow(id);
        User writer = findApp.getUser();

        return new AppWithAgeResponseDto(findApp.getTitle(), findApp.getContents(), writer.getAge());
    }

    public AppResponseDto update(String title, String contents){
        return null;
    }

    public void delete(Long id) {
        App findApp = appRepository.findByIdOrElseThrow(id);

        appRepository.delete(findApp);
    }
}

package com.example.app.service;

import com.example.app.dto.SignUpResponseDto;
import com.example.app.dto.UserResponseDto;
import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String email, String password, Integer age) {

        User user = new User(username, email, password, age); // 만들어준 member를

        User savedUser = userRepository.save(user);// member repository에 save를 통해서 member를 매개변수로 전달해줘

        return new SignUpResponseDto(savedUser.getId(),  savedUser.getUsername(), savedUser.getEmail(), savedUser.getAge());
    }

    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id :" + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getAge());

    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);

    }

}


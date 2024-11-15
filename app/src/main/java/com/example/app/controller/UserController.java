package com.example.app.controller;

import com.example.app.dto.SignUpRequestDto;
import com.example.app.dto.SignUpResponseDto;
import com.example.app.dto.UserResponseDto;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> singUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword(),
                        requestDto.getAge()

                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public String login(@Validated @ModelAttribute LoginRequestDto request, HttpServletResponse response) {
//        LoginResponseDto responseDto = userService.login(request.getEmail(), request.getPassword());
//
//        if (responseDto.getEmail() == null) {
//            return "다시 login";
//        }
//        Cookie cookie = new Cookie("userEmail", String.valueOf(responseDto.getEmail()));
//        response.addCookie(cookie);
//        return new LoginResponseDto(String password, String email);
//    }
//    @PostMapping("/login")
//    Cookie cookie = new Cookie("email", String.valueOf(LoginResponseDto.getEmail()));

}

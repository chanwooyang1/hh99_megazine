package com.sparta.megazine.controller;



import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.UserRequestDto;

import com.sparta.megazine.dto.UserResponseDto;
import com.sparta.megazine.repository.UserRepository;

import com.sparta.megazine.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;
    private final UserRepository userRepository;


    // 회원가입
    @PostMapping("/register")
    public boolean register(@RequestBody UserRequestDto.Register userRegister) {
        return userService.register(userRegister);

    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto.Login userLogin) {

        return userService.login(userLogin);
    }


    @GetMapping("/user")
    public UserResponseDto getUserInfo(@AuthenticationPrincipal User user){

        return userService.userInfo(user);
    }



}


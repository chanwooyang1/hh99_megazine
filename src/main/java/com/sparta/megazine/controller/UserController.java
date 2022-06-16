package com.sparta.megazine.controller;



import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.UserRequestDto;

import com.sparta.megazine.repository.UserRepository;

import com.sparta.megazine.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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

    //해결 못해서 팀원분꺼 복붙
    @GetMapping("/user")
    public UserInfo userInfo(@AuthenticationPrincipal User user) {

        User findUser = userRepository.findById(user.getId()).orElseThrow(()
                -> new IllegalArgumentException("유저 정보가 존재하지 않음"));
        return new UserInfo(findUser);
    }

    //ResponseUser 필요
    @Data
    @AllArgsConstructor
    static class UserInfo {
        private String name;
        private String nickname;
        private String email;
        private String introduce;
        private String profile_image_url;
        private LocalDateTime createdAt;


        public UserInfo(User user) {
            this.name = user.getName();
            this.nickname = user.getNickname();
            this.email = user.getEmail();
            this.profile_image_url = user.getProfile_image_url();
            this.introduce = user.getIntroduce();
            this.createdAt = user.getCreatedAt();

        }
    }
}


package com.sparta.megazine.controller;


import com.sparta.megazine.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.sparta.megazine.repository.UserRepository;
import com.sparta.megazine.security.JwtTokenProvider;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/register")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .profile_image_url(user.get("profile_image_url"))
                .introduce(user.get("introduce"))
                .nickname(user.get("nickname"))
                .name(user.get("name"))
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User user1 = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), user1.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(user1.getUsername(), user1.getRoles());
    }
}

//    @GetMapping("/user")
//    public User getUserInfo(@RequestBody UserRepository userRepository){
//
//    }
//}


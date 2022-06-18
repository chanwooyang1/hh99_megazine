package com.sparta.megazine.service;

import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.UserRequestDto;
import com.sparta.megazine.dto.UserResponseDto;
import com.sparta.megazine.repository.UserRepository;
import com.sparta.megazine.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    public boolean register(UserRequestDto.Register userRegister){
        if(userRepository.existsUserByEmail(userRegister.getEmail())){
            throw new IllegalArgumentException("중복된 e-mail 입니다.");
        }

        User registerUser = User.builder()
                .introduce(userRegister.getIntroduce())
                .nickname(userRegister.getNickname())
                .name(userRegister.getName())
                .email(userRegister.getEmail())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();
        userRepository.save(registerUser);
        return true;
    }

    public String login(UserRequestDto.Login userLogin){

        User loginUser = userRepository.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 e-mail 입니다."));
        if (!passwordEncoder.matches(userLogin.getPassword(), loginUser.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtTokenProvider.createToken(loginUser.getUsername(), loginUser.getRoles());
        }

    public UserResponseDto userInfo(@AuthenticationPrincipal User user){
        User oneUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new UserResponseDto(oneUser);
    }


    }







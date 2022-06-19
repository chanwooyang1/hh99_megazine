package com.sparta.megazine.dto;

import com.sparta.megazine.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private String name;
    private String nickname;
    private String email;
    private String introduce;
    private String createdAt;

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.introduce = user.getIntroduce();
        this.createdAt = String.valueOf(user.getCreatedAt());
    }
}



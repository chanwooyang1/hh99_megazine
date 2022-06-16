package com.sparta.megazine.dto;

import com.sparta.megazine.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserResponseDto {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class userInfo {
        private String name;
        private String nickname;
        private String email;
        private String introduce;
        private String profileImageUrl;
        private LocalDateTime createdAt;


        public userInfo(User user) {
            this.name = user.getName();
            this.nickname = user.getNickname();
            this.email = user.getEmail();
            this.introduce = user.getIntroduce();
            this.createdAt = user.getCreatedAt();
            this.profileImageUrl = user.getProfile_image_url();
        }
    }
}

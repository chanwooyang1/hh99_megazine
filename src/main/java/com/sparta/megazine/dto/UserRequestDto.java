package com.sparta.megazine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserRequestDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Register{
        private String name;
        private String nickname;
        private String email;
        private String password;
        private String introduce;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Login{
        private String email;
        private String password;
    }
}

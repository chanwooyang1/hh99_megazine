package com.sparta.megazine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Login{
        private String email;
        private String password;
    }
}

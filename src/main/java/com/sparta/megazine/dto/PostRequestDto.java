package com.sparta.megazine.dto;
import lombok.*;

import java.time.LocalDateTime;


public class PostRequestDto  {





    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class CreatePost{
        private Long userId;
        private String title;
        private String content;
        private String imageUrl;

    }
}
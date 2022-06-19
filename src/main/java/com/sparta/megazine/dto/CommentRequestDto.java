package com.sparta.megazine.dto;

import lombok.*;
import org.springframework.stereotype.Service;

public class CommentRequestDto {


    @Getter
    @Service
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Setter
    public static class CreateComment{
        Long userId;
        String content;
    }


    @Getter
    @Service
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Setter
    public static class UpdateComment{
        Long postId;
        Long commentId;
        String content;

    }

    public static class DeleteComment{
        Long postId;
        Long commentId;


    }
}

package com.sparta.megazine.dto;


import com.sparta.megazine.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Data
public class PostResponseDto{
    private String nickname, imageUrl, content, title;
    private Long postId, viewCount, template;
    private LocalDateTime createdAt, modifiedAt;


    public PostResponseDto(Post post) {
        this.nickname = post.getUser().getNickname();
        this.template = post.getTemplates();
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.postId = post.getId();
        this.viewCount = post.getViewCount();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }


}

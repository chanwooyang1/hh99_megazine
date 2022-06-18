package com.sparta.megazine.service;


import com.sparta.megazine.domain.Post;
import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.PostRequestDto;
import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


@Transactional
public PostRequestDto.CreatePost createPost(PostRequestDto.CreatePost postRequestDto, User user){
    postRequestDto.setUserId(user.getId());
    User loginUser = userRepository.findById(postRequestDto.getUserId()).orElseThrow(
            () -> new IllegalArgumentException("현재 로그인되어 있지 않습니다."));
    Post newPost = Post.builder()
            .user(loginUser)
            .content(postRequestDto.getContent())
            .title(postRequestDto.getTitle())
            .imageUrl((postRequestDto.getImageUrl()))
            .build();
    postRepository.save(newPost);


    return postRequestDto;
}
}

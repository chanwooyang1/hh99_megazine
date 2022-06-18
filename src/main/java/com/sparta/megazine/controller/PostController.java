package com.sparta.megazine.controller;

import com.sparta.megazine.domain.Post;

import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.PostRequestDto;
import com.sparta.megazine.dto.PostResponseDto;
import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;


//    CRUD 추가해야함

    @GetMapping("")
    public List<PostResponseDto> getPosts(){
        List<Post> getPostList = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> list = new ArrayList<>();
        return list;
    }




    @GetMapping("/{postId}")
    public Post onePost(@PathVariable Long postID){
        return postRepository.findById(postID).orElseThrow(() -> new IllegalArgumentException("게시글 아이디가 존재하지 않습니다."));

    }

    @PostMapping("")
    public PostRequestDto.CreatePost createPost(@RequestBody PostRequestDto.CreatePost postRequestDto, @AuthenticationPrincipal User user){
        return postService.createPost(postRequestDto, user);
    }






}

package com.sparta.megazine.controller;

import com.sparta.megazine.domain.Post;

import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;


//    CRUD 추가해야함

    @GetMapping("")
    public List<Post> getPost(){
        return postRepository.findAll();
    }




    @GetMapping("/{postId}")
    public Post onePost(@PathVariable Long postID){
        return postRepository.findById(postID).orElseThrow(() -> new IllegalArgumentException("게시글 아이디가 존재하지 않습니다."));

    }





}

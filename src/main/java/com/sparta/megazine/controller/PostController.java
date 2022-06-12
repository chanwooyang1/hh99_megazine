package com.sparta.megazine.controller;

import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;


//    CRUD 추가해야함
}

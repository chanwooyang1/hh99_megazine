package com.sparta.megazine.service;


import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
}

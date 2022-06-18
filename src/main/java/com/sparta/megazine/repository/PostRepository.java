package com.sparta.megazine.repository;

import com.sparta.megazine.domain.Post;
import com.sparta.megazine.dto.PostResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostResponseDto> findAllByOrderByCreatedAtDesc();
}

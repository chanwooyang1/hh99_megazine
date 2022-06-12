package com.sparta.megazine.repository;

import com.sparta.megazine.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

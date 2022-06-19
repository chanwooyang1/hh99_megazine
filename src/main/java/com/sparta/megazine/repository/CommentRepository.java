package com.sparta.megazine.repository;

import com.sparta.megazine.domain.Comment;
import com.sparta.megazine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByUserAndId(User user, Long id);

    void deleteByIdAndUser(User user, Long id);
}

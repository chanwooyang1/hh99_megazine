package com.sparta.megazine.controller;

import com.sparta.megazine.domain.Comment;
import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.CommentRequestDto;
import com.sparta.megazine.repository.CommentRepository;
import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.repository.UserRepository;
import com.sparta.megazine.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;




//db에 저장은 되는데 404 not found가 뜬다
    @Transactional
    @PostMapping("/{postId}")
    public CommentRequestDto.CreateComment createComment(@AuthenticationPrincipal User user, @PathVariable Long postId, @RequestBody CommentRequestDto.CreateComment createComment ){
        return commentService.createComment(user, postId, createComment);


    }

    @Transactional
    @PutMapping("/{commentId}")
    public boolean updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto.UpdateComment updateComment, @AuthenticationPrincipal User user){
        //예외처리

        commentService.updateComment(user, commentId, updateComment);
        return true;
    }



    @Transactional
    @DeleteMapping("/{commentId}")
    public boolean deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal User user){
        commentService.deleteComment(user,commentId);
        return true;
    }
}




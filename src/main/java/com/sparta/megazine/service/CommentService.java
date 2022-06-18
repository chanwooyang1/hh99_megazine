package com.sparta.megazine.service;

import com.sparta.megazine.domain.Comment;
import com.sparta.megazine.domain.Post;
import com.sparta.megazine.domain.User;
import com.sparta.megazine.dto.CommentRequestDto;
import com.sparta.megazine.repository.CommentRepository;
import com.sparta.megazine.repository.PostRepository;
import com.sparta.megazine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;





    public CommentRequestDto.CreateComment createComment (User user,Long postId, CommentRequestDto.CreateComment createComment){
        createComment.setUserId(user.getId());
        Post thisPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        User thisUser = userRepository.findById(user.getId()).orElseThrow(()-> new IllegalArgumentException("사용자가 존재하지 않습니다"));

        Comment comment = Comment.builder()
                .content(createComment.getContent())
                .user(thisUser)
                .post(thisPost)
                .build();
        commentRepository.save(comment);
        return createComment;


    }
    @Transactional
    public void updateComment (User user, Long commentId, CommentRequestDto.UpdateComment updateComment ){
        Comment comment = commentRepository.findCommentByUserAndId(user, commentId);
        comment.update(updateComment.getContent());
    }

    public void deleteComment (User user, Long commentId){
        commentRepository.deleteByIdAndUser(user, commentId);

    }
}

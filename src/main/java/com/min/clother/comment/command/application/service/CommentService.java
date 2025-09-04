package com.min.clother.comment.command.application.service;

import com.min.clother.adviceBoard.command.domain.repository.BoardCommandRepository;
import com.min.clother.comment.command.application.dto.CommentDTO;
import com.min.clother.comment.command.domain.aggregate.Comment;
import com.min.clother.comment.command.domain.repository.CommentRepository;
import com.min.clother.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardCommandRepository boardCommandRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentDTO createComment(CommentDTO commentDto) {

        // 댓글 저장
        Comment comment = commentDto.toEntity();
        commentRepository.save(comment);

        Integer boardId = commentDto.getBoardId();
        Integer postId = commentDto.getPostId();

        // 댓글 수 증가 로직
        if (boardId != null) {
            boardCommandRepository.increaseCommentCount(boardId);
        } else if (postId != null) {
            postRepository.increaseCommentCount(postId);
        }
        return CommentDTO.fromEntity(comment);

    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 존재하지 않습니다: " + commentId));
        comment.setIsDeleted(true);

        // 댓글 수 삭제 로직
        if (comment.getBoardId() != null) {
            boardCommandRepository.decreaseCommentCount(comment.getBoardId());
        } else if (comment.getPostId() != null) {
            postRepository.decreaseCommentCount(comment.getPostId());

            commentRepository.save(comment); // 변경된 댓글 저장
        }

    }
}


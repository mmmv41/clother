package com.min.clother.likes.command.application.service;

import com.min.clother.adviceBoard.command.domain.repository.BoardCommandRepository;
import com.min.clother.comment.command.domain.repository.CommentRepository;
import com.min.clother.likes.command.application.dto.LikeDTO;
import com.min.clother.likes.command.domain.aggregate.Like;
import com.min.clother.likes.command.domain.repository.LikeRepository;
import com.min.clother.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final BoardCommandRepository boardCommandRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    // 좋아요 등록
    @Transactional
    public void createLike(LikeDTO likeDTO) {

        Integer userId = likeDTO.getUserId();
        Integer boardId = likeDTO.getBoardId();
        Integer postId = likeDTO.getPostId();
        Integer commentId = likeDTO.getCommentId();

        //  중복 좋아요 체크
        boolean alreadyExists =
                (boardId != null && likeRepository.existsByUserIdAndBoardId(userId, boardId)) ||
                        (postId != null && likeRepository.existsByUserIdAndPostId(userId, postId)) ||
                        (commentId != null && likeRepository.existsByUserIdAndCommentId(userId, commentId));

        if (alreadyExists) {
            throw new IllegalStateException("이미 좋아요를 누르셨습니다.");
        }

        // 좋아요 저장
        Like like = likeDTO.toEntity();
        likeRepository.save(like);

        // 좋아요 수 증가 로직
        if (boardId != null) {
            boardCommandRepository.increaseLikeCount(boardId);
        } else if (postId != null) {
            postRepository.increaseLikeCount(postId);
        } else if (commentId != null) {
            commentRepository.increaseLikeCount(commentId);
        }

    }


    // 좋아요 등록 해제
    @Transactional
    public void deleteLike(int id) {
        Like like = likeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 ID를 찾을 수 없습니다: " + id));

        // 좋아요수 등록 해제
        if (like.getBoardId() != null) {
            boardCommandRepository.decreaseLikeCount(like.getBoardId());
        } else if (like.getPostId() != null) {
            postRepository.decreaseLikeCount(like.getPostId());
        } else if (like.getCommentId() != null) {
            commentRepository.decreaseLikeCount(like.getCommentId());
        }

        // 좋아요 등록 해제
        likeRepository.deleteById(id);

    }


}





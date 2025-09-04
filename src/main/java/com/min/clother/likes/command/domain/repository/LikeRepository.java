package com.min.clother.likes.command.domain.repository;

import com.min.clother.likes.command.domain.aggregate.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
//    boolean existsByUserId(Integer userId, Integer boardId, Integer postId, Integer commentId);

    boolean existsByUserIdAndBoardId(Integer userId, Integer boardId);

    boolean existsByUserIdAndPostId(Integer userId, Integer postId);

    boolean existsByUserIdAndCommentId(Integer userId, Integer commentId);
}

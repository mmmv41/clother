package com.min.clother.adviceBoard.command.domain.repository;

import com.min.clother.adviceBoard.command.domain.aggregate.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommandRepository extends JpaRepository<BoardEntity, Integer> {
    @Modifying
    @Query("UPDATE BoardEntity b SET b.likeCount = b.likeCount + 1 WHERE b.id = :boardId")
    void increaseLikeCount(Integer boardId);

    @Modifying
    @Query("UPDATE BoardEntity b SET b.likeCount = b.likeCount - 1 WHERE b.id = :boardId")
    void decreaseLikeCount(Integer boardId);

    @Modifying
    @Query("UPDATE BoardEntity b SET b.commentCount = b.commentCount + 1 WHERE b.id = :boardId")
    void increaseCommentCount(Integer boardId);

    @Modifying
    @Query("UPDATE BoardEntity b SET b.commentCount = b.commentCount - 1 WHERE b.id = :boardId")
    void decreaseCommentCount(Integer boardId);
}

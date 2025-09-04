package com.min.clother.post.command.domain.repository;


import com.min.clother.post.command.domain.aggregate.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Modifying
    @Query("UPDATE PostEntity p SET p.likeCount = p.likeCount + 1 WHERE p.id = :postId")
    void increaseLikeCount(Integer postId);

    @Modifying
    @Query("UPDATE PostEntity p SET p.likeCount = p.likeCount - 1 WHERE p.id = :postId")
    void decreaseLikeCount(Integer postId);

    @Modifying
    @Query("UPDATE PostEntity p SET p.commentCount = p.commentCount + 1 WHERE p.id = :postId")
    void increaseCommentCount(Integer postId);

    @Modifying
    @Query("UPDATE PostEntity p SET p.commentCount = p.commentCount - 1 WHERE p.id = :postId")
    void decreaseCommentCount(Integer postId);
}

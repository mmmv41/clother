package com.min.clother.likes.command.application.dto;

import com.min.clother.likes.command.domain.aggregate.Like;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LikeDTO {
    private int id;
    private int userId;

    private Integer postId;
    private Integer boardId;
    private Integer commentId;


    public static LikeDTO fromEntity(Like like) {
        return LikeDTO.builder()
                .id(like.getId())
                .userId(like.getUserId())
                .postId(like.getPostId())
                .boardId(like.getBoardId())
                .commentId(like.getCommentId())
                .build();
    }

    public Like toEntity() {
        return Like.builder()
                .userId(this.userId)
                .postId(this.postId)
                .boardId(this.boardId)
                .commentId(this.commentId)
                .build();
    }
}

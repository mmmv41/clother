package com.min.clother.comment.command.application.dto;

import com.min.clother.comment.command.domain.aggregate.Comment;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private int id;
    private int userId;
    private Integer postId;
    private Integer boardId;
    private Integer parentId;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isDeleted = false;
    private int likeCount;

    public static CommentDTO fromEntity(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .userId(comment.getUserId())
                .postId(comment.getPostId())
                .boardId(comment.getBoardId())
                .parentId(comment.getParentId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .isDeleted(comment.getIsDeleted())
                .likeCount(comment.getLikeCount())
                .build();
    }

    public Comment toEntity() {
        return Comment.builder()
                .userId(this.userId)
                .postId(this.postId)
                .boardId(this.boardId)
                .parentId(this.parentId)
                .content(this.content)
                .isDeleted(this.isDeleted != null ? this.isDeleted : false)
                .createdAt(this.createdAt != null ? this.createdAt : LocalDateTime.now())
                .likeCount(this.likeCount)
                .build();
    }
}


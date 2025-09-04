package com.min.clother.comment.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 댓글 ID

    @Column(nullable = false)
    private int userId; // 회원 ID


    private Integer postId; // 포스트 ID (NULL 가능)


    private Integer boardId; // 게시판 ID (NULL 가능)

    private Integer parentId; // 부모 댓글 ID (NULL 가능)

    @Column(nullable = false, length = 255)
    private String content; // 댓글 내용

    @Column(nullable = false)
    private int likeCount = 0;

    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성 시간

    @Column(nullable = false)
    private Boolean isDeleted = false; // 삭제 여부 (기본값 FALSE)

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}


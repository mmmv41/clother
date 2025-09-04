package com.min.clother.likes.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; // 댓글 ID

    @Column(nullable = false)
    private int userId; // 회원 ID


    private Integer postId; // 포스트 ID (NULL 가능)

    private Integer commentId; // 댓글 ID (NULL 가능)

    private Integer boardId; // 게시판 ID (NULL 가능)

}
package com.min.clother.comment.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter

public class CommentDTO {
    private int id;
    private String type;   // post, board, comment
    private String content; // 댓글 내용
    private LocalDateTime createdDate; // 생성 시간
    private boolean isDeleted; // 삭제 여부
    private Integer parentId;
}

package com.min.clother.likes.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class LikeDTO {
    private int id; // 좋아요 대상 ID
    private String type; // post, comment, board
    private String content; // 내용
    private LocalDateTime createdAt; // 생성 날짜
}

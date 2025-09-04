package com.min.clother.post.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ResponsePostFeedDTO {
    private int id; // post id
    private int likeCount; // 좋아요 수
    private int commentCount; // 댓글 수
    private String thumbnailUrl; // 썸네일 이미지 URL
}

package com.min.clother.post.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostImageDTO {
    int id; // postImage id
    String imageUrl; // 이미지 url
    int order; // 순서
}

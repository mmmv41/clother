package com.min.clother.post.query.dto;

import java.util.List;
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
public class RequestFeedDTO {
    private Integer minHeight;
    private Integer maxHeight;
    private Integer minWeight;
    private Integer maxWeight;

    private List<Integer> lookTagIds;
    private List<Integer> categoryIds;

    private Integer lastPostId; // 무한 스크롤용: 이전 마지막 postId
    private String sort; // "latest" or "likes"
}

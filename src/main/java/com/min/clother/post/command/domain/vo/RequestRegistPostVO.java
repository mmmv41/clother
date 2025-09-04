package com.min.clother.post.command.domain.vo;

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
public class RequestRegistPostVO {
    private String content;
    private List<PostImageVO> imageVOs;

    // 없을 수도 있음
    private List<Integer> lookTagIds;
    private List<ProductTagVO> productTagVOs;
    private HairTagVO hairTagVO;
}

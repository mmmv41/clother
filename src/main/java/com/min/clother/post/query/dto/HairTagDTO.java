package com.min.clother.post.query.dto;

import java.math.BigDecimal;
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
public class HairTagDTO {
    int id; // 태그 id
    int categoryId; // 카테고리 id
    BigDecimal hairTagPositionX; // 헤어태그 x 좌표
    BigDecimal hairTagPositionY; // 헤어태그 y 좌표
    String hairShopLink; // 헤어샵 링크
    String hairShopName; // 헤어샵 이름
}

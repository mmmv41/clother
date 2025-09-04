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
public class ProductTagDTO {
    int id; // 태그 id
    int categoryId; // 카테고리 id
    BigDecimal productTagPositionX; // 상품 태그 x 좌표
    BigDecimal productTagPositionY; // 상품 태그 y 좌표

    int productId; // 상품 id
    String productBrandName; // 상품 브랜드
    String productName; // 상품 이름
    String productLink; // 상품 판매 링크
    int productPrice; // 상품 가격
    String productImageUrl; // 상품 사진 URL
}

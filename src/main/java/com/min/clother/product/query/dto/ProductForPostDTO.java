package com.min.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductForPostDTO {
    private int id; // 상품 번호
    private String brandName; // 브랜드명
    private String name; // 상품명
    private int price; // 가격
    private String link; // 제품 url
    private String imageUrl; // 상품 이미지
    private int categoryId; // 카테고리 번호
    private String categoryName; // 카테고리 이름
}

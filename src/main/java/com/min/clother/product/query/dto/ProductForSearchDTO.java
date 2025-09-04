package com.min.clother.product.query.dto;

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
public class ProductForSearchDTO {
    private int id; // 상품 id
    private String brandName; // 브랜드명
    private String name; // 상품명
    private String imageUrl; // 상품 이미지
    private String link; // 상품 판매 링크
    private int categoryId; // 카테고리 id
}

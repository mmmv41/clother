package com.min.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductDTO {
    private int id; // 상품 id
    private String brandName; // 브랜드명
    private String name; // 상품명
    private String imageUrl; // 상품 이미지
}

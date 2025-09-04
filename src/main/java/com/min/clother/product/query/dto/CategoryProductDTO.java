package com.min.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CategoryProductDTO {
    private int id;  // 카테고리 id
    private String name; // 카테고리 이름
    private List<ProductDTO> products; // 해당 카테고리의 상품 목록
}

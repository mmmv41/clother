package com.min.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CategoryDTO {
    private int id; // 카테고리 번호
    private String name; // 카테고리 명
}

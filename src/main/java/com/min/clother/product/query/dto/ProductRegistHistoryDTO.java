package com.min.clother.product.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductRegistHistoryDTO {
    private int id; // 상품 신청 번호
    private String brandName; // 브랜드명
    private String name; // 등록한 상품명
    private Date createdAt; // 상품 신청일
    private String productLink; // 상품 링크
}

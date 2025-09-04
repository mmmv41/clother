package com.min.clother.product.query.controller;

import com.min.clother.product.query.dto.CategoryDTO;
import com.min.clother.product.query.dto.CategoryProductDTO;
import com.min.clother.product.query.dto.ProductDTO;
import com.min.clother.product.query.dto.ProductDetailDTO;
import com.min.clother.product.query.dto.ProductForPostDTO;
import com.min.clother.product.query.dto.ProductRegistHistoryDTO;
import com.min.clother.product.query.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 하위 카테고리 목록 조회
    @GetMapping("/categories/{categoryName}")
    public ResponseEntity<List<CategoryDTO>> getSubCategories(
            @PathVariable("categoryName") String categoryName) {
        List<CategoryDTO> categories = productService.getSubCategories(categoryName);

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    // 최하위 카테고리 별 상품 목록 조회
    @GetMapping("/categories/{categoryName}/products")
    public ResponseEntity<CategoryProductDTO> getProductsByCategory(
            @PathVariable("categoryName") String categoryName) {
        CategoryProductDTO products = productService.getProductListByCategory(categoryName);
        return ResponseEntity.ok(products);
    }

    // 사용자가 등록 신청한 상품 목록 조회
    @GetMapping("/users/{userId}/mypage")
    public ResponseEntity<List<ProductRegistHistoryDTO>> getProductRegistHistoryByUserId(
            @PathVariable("userId") int userId) {
        List<ProductRegistHistoryDTO> productHistories = productService.getProductRegistHistoryByUserId(userId);
        return ResponseEntity.ok(productHistories);
    }

    // 상품 상세 정보 조회
    @GetMapping("/categories/post/{productId}/productdetail")
    public ResponseEntity<ProductDetailDTO> getProductDetailByProductId(
            @PathVariable("productId") int productId) {
        ProductDetailDTO productDetail = productService.getProductDetailByProductId(productId);
        return ResponseEntity.ok(productDetail);
    }

    // post domain에서 요청
    @GetMapping("/products")
    public ResponseEntity<List<ProductForPostDTO>> getProducts(@RequestParam List<Integer> productIds) {
        List<ProductForPostDTO> products = productService.getProductsByIds(productIds);

        return ResponseEntity.ok(products);
    }

    // posting 시 상품 태그 추가를 위한 검색
    @GetMapping("/products/search")
    public ResponseEntity<List<ProductDTO>> getProductsByKeyword(@RequestParam String keyword) {
        List<ProductDTO> products = productService.getProductsByKeyword(keyword);

        return ResponseEntity.ok(products);
    }

}

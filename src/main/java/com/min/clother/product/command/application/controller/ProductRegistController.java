package com.min.clother.product.command.application.controller;

import com.min.clother.product.command.application.dto.ProductRegistDTO;
import com.min.clother.product.command.application.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ProductRegistController {

    private final ProductService productService;

    public ProductRegistController(ProductService productService) {
        this.productService = productService;
    }

    /* 설명. 상품 등록하기 (insert) */
    @PostMapping("/users/{userId}/applications")
    public String applyForProductRegistration(
            @PathVariable("userId") int userId,
            @RequestBody ProductRegistDTO newProduct) {
        newProduct.setUserId(userId); // userId 는 로그인을 가정하고 Id 값만 받아옴
        productService.applyForProductRegistration(newProduct);
        return "상품 등록 신청이 완료되었습니다";
    }

    /* 설명. 등록 신청한 상품 수정하기 (update) */
    @PatchMapping("/users/{userId}/applications/{productId}")
    public String modifyProduct(
            @PathVariable int productId,
            @PathVariable int userId,
            @RequestBody ProductRegistDTO modifiedProduct) {
        modifiedProduct.setUserId(userId);
        productService.updateProduct(productId, modifiedProduct);
        return productId + "번의 상품 등록 내역 수정이 완료되었습니다";
    }

    /* 설명. 등록 신청한 상품 삭제하기 (delete) */
    @DeleteMapping("/users/{userId}/applications/{productId}")
    public String deleteProduct(
            @PathVariable int productId) {
        productService.deleteProduct(productId);
        return productId + "번의 상품 등록 내역 삭제가 완료되었습니다";
    }

}

package com.min.clother.product.command.application.service;

import com.min.clother.product.command.application.dto.ProductRegistDTO;
import com.min.clother.product.command.domain.aggregate.ProductRegist;
import com.min.clother.product.command.domain.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void applyForProductRegistration(ProductRegistDTO newProduct) {

        // DTO → Entity 매핑
        ProductRegist productEntity = modelMapper.map(newProduct, ProductRegist.class);

        // userId 값 설정
        productEntity.setId(0); // 새로운 상품으로 인식되도록 id를 0으로 초기화
        productEntity.setUserId(newProduct.getUserId());
        productRepository.save(productEntity);
    }

    @Transactional
    public void updateProduct(int productId, ProductRegistDTO modifiedProduct) {
        ProductRegist productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("해당 상품 등록 내역을 찾을 수 없습니다."));

        productEntity.update(modifiedProduct);
        productRepository.save(productEntity);
    }

    @Transactional
    public void deleteProduct(int productId) {

        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("해당 상품 등록 내역을 찾을 수 없습니다.");
        }
        productRepository.deleteById(productId);
    }

    // User 서버에서 사용자 정보를 받아오기
//    public UserDTO getUserById(int userId) {
//
//    }

}

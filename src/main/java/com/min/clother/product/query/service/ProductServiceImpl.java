package com.min.clother.product.query.service;

import com.min.clother.product.query.dto.CategoryDTO;
import com.min.clother.product.query.dto.CategoryProductDTO;
import com.min.clother.product.query.dto.ProductDTO;
import com.min.clother.product.query.dto.ProductDetailDTO;
import com.min.clother.product.query.dto.ProductForPostDTO;
import com.min.clother.product.query.dto.ProductRegistHistoryDTO;
import com.min.clother.product.query.repository.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    /*  User 도메인과 연결  */

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<CategoryDTO> getSubCategories(String categoryName) {
        List<CategoryDTO> categoryDTOList = productMapper.selectSubCategories(categoryName);
        return categoryDTOList;
    }

    @Override
    public CategoryProductDTO getProductListByCategory(String categoryName) {
        CategoryProductDTO categoryProductDTO = productMapper.selectAllProductsByCategory(categoryName);
        return categoryProductDTO;
    }

    @Override
    public List<ProductRegistHistoryDTO> getProductRegistHistoryByUserId(int userId) {
        List<ProductRegistHistoryDTO> productRegistHistoryDTOList = productMapper.selectProductHistoryByUserId(userId);
        return productRegistHistoryDTOList;
    }

    @Override
    public ProductDetailDTO getProductDetailByProductId(int productId) {
        ProductDetailDTO productDetailDTO = productMapper.selectProductDetailByProductId(productId);
        return productDetailDTO;
    }

    @Override
    public List<ProductForPostDTO> getProductsByIds(List<Integer> productIds) {
        return productMapper.selectProductsByIds(productIds);
    }

    @Override
    public List<ProductDTO> getProductsByKeyword(String keyword) {
        return productMapper.selectProductsByKeyword(keyword);
    }
}

package com.min.clother.product.query.service;

import com.min.clother.product.query.dto.CategoryDTO;
import com.min.clother.product.query.dto.CategoryProductDTO;
import com.min.clother.product.query.dto.ProductDTO;
import com.min.clother.product.query.dto.ProductDetailDTO;
import com.min.clother.product.query.dto.ProductForPostDTO;
import com.min.clother.product.query.dto.ProductRegistHistoryDTO;

import java.util.List;

public interface ProductService {

    List<CategoryDTO> getSubCategories(String categoryId);

    CategoryProductDTO getProductListByCategory(String categoryName);

    List<ProductRegistHistoryDTO> getProductRegistHistoryByUserId(int userId);

    ProductDetailDTO getProductDetailByProductId(int productId);

    List<ProductForPostDTO> getProductsByIds(List<Integer> productIds);

    List<ProductDTO> getProductsByKeyword(String keyword);
}

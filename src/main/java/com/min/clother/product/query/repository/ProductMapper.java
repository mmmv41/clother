package com.min.clother.product.query.repository;

import com.min.clother.product.query.dto.CategoryDTO;
import com.min.clother.product.query.dto.CategoryProductDTO;
import com.min.clother.product.query.dto.ProductDTO;
import com.min.clother.product.query.dto.ProductDetailDTO;
import com.min.clother.product.query.dto.ProductForPostDTO;
import com.min.clother.product.query.dto.ProductRegistHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<CategoryDTO> selectSubCategories(String categoryName);

    CategoryProductDTO selectAllProductsByCategory(String categoryName);

    List<ProductRegistHistoryDTO> selectProductHistoryByUserId(int userId);

    ProductDetailDTO selectProductDetailByProductId(int productId);

    List<ProductForPostDTO> selectProductsByIds(List<Integer> productIds);

    List<ProductDTO> selectProductsByKeyword(String keyword);
}

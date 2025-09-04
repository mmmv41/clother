package com.min.clother.product.command.domain.repository;

import com.min.clother.product.command.domain.aggregate.ProductRegist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductRegist, Integer> {

}

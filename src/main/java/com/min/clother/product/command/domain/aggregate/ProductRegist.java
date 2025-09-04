package com.min.clother.product.command.domain.aggregate;

// 사용자가 등록 신청한 제품

import com.min.clother.product.command.application.dto.ProductRegistDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "product_registration")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductRegist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "id")
    private int id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "product_link")
    private String productLink;

    @Column(name = "user_id", nullable = false)
    private int userId;

    public void update(ProductRegistDTO modifiedProduct) {

        // 등록 시간은 수정되지 않도록 함
        if (this.createdAt == null) {
            this.createdAt = modifiedProduct.getCreatedAt() != null ? modifiedProduct.getCreatedAt() : new Date();
        }

        this.brandName = modifiedProduct.getBrandName();
        this.name = modifiedProduct.getName();
        this.productLink = modifiedProduct.getProductLink();
    }
}

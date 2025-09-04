package com.min.clother.post.command.domain.vo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductTagVO {
    private int productId;
    private int categoryId;
    private BigDecimal productTagPositionX;
    private BigDecimal productTagPositionY;
}

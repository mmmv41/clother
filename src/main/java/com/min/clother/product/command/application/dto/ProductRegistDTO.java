package com.min.clother.product.command.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRegistDTO {
    private String brandName;
    private String name;
    private String productLink;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date createdAt = new Date(); // 기본값 현재 시간이 들어가게
    private int userId;
}

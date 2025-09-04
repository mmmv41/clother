package com.min.clother.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.min.clother.post", annotationClass = Mapper.class)
public class PostConfig {
}

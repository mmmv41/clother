package com.min.clother;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.min.clother", annotationClass = Mapper.class)
@SpringBootApplication(scanBasePackages = "com.min.clother")
public class ClotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClotherApplication.class, args);
    }

}

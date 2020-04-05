package com.machun.springbootmybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author machun1
 */
@SpringBootApplication
@MapperScan( basePackages = "com.machun.springbootmybatisannotation.mapper")
public class SpringbootMybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisAnnotationApplication.class, args);
    }

}

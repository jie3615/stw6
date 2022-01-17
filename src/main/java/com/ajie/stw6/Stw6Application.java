package com.ajie.stw6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.ajie.stw6.*" )

public class Stw6Application {

    public static void main(String[] args) {
        SpringApplication.run(Stw6Application.class, args);
    }

}

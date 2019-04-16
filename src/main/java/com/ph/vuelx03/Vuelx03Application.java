package com.ph.vuelx03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ph.vuelx03.dao")
public class Vuelx03Application {

    public static void main(String[] args) {
        SpringApplication.run(Vuelx03Application.class, args);
    }

}

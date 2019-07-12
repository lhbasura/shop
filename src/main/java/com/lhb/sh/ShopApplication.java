package com.lhb.sh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lhb.sh.mapper")
public class ShopApplication {
    public static void main(String[]args)
    {
        SpringApplication.run(ShopApplication.class,args);
    }
}

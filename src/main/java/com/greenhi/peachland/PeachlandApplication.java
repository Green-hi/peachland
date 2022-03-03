package com.greenhi.peachland;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.greenhi.peachland.mapper")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
public class PeachlandApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeachlandApplication.class, args);
    }

}

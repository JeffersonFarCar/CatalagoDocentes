package com.demo.catalagodocentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CatalagoDocentesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalagoDocentesApplication.class, args);
    }

}

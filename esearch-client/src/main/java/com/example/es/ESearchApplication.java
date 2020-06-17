package com.example.es;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * mapper
 *
 * @author yichuan
 */
@EnableSwagger2
@SpringBootApplication
public class ESearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ESearchApplication.class, args);
    }

}

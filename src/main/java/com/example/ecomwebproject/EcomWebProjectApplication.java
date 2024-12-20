package com.example.ecomwebproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class EcomWebProjectApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(EcomWebProjectApplication.class, args);
    }

}

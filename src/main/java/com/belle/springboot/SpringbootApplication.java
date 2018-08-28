package com.belle.springboot;

import com.belle.springboot.filter.JwtFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.belle.springboot.dao")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run (SpringbootApplication.class, args);
    }


}

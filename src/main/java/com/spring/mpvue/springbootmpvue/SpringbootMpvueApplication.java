package com.spring.mpvue.springbootmpvue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.spring.mpvue.springbootmpvue.mybatis.mapper")
public class SpringbootMpvueApplication  {//extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMpvueApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // TODO Auto-generated method stub
////      return super.configure(builder);
//        return builder.sources(this.getClass());
//    }
}

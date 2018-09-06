package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gf on 2018/9/6.
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){

        return "spring security hello";
    }
}

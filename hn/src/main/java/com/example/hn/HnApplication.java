package com.example.hn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HnApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnApplication.class, args);

    }

}

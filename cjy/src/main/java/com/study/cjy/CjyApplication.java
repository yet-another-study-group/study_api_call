package com.study.cjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CjyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CjyApplication.class, args);
	}

}

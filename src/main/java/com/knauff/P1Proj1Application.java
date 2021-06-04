package com.knauff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class P1Proj1Application {

	public static void main(String[] args) {
		SpringApplication.run(P1Proj1Application.class, args);
	}

}

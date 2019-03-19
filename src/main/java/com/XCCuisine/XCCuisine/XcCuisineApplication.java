package com.XCCuisine.XCCuisine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.XCCuisine.XCCuisine.api.dao")
public class XcCuisineApplication {
	public static void main(String[] args) {
		SpringApplication.run(XcCuisineApplication.class, args);
	}

}

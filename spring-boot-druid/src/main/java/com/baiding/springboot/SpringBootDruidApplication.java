package com.baiding.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.baiding.springboot.dao")
@SpringBootApplication
public class SpringBootDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDruidApplication.class, args);
	}
}

package com.baibai.rush;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.baibai.rush.db.mappers")
@ComponentScan(basePackages = {"com.baibai"})
public class RushApplication {

	public static void main(String[] args) {
		SpringApplication.run(RushApplication.class, args);
	}

}

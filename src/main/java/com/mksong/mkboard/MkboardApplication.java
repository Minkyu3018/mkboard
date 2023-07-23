package com.mksong.mkboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.mksong.mkboard.**.mappers"})
@SpringBootApplication
public class MkboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MkboardApplication.class, args);
	}

}

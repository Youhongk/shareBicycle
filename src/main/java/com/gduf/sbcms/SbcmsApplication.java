package com.gduf.sbcms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gduf.sbcms.dao")
public class SbcmsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SbcmsApplication.class, args);
	}
}
